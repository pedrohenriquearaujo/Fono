package com.example.unicap.fono;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;

import com.example.unicap.model.Exercicio;
import com.example.unicap.model.Licao;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AudioAdapter  extends ArrayAdapter<Exercicio> {

    private Context context;
    private List<Exercicio> exercicioList;
    private MediaPlayer mediaPlayer = new MediaPlayer();
    boolean audio;

    private String path = Environment.getExternalStorageDirectory() + File.separator;

    public AudioAdapter(Context context, List<Exercicio> list) {
        super(context, 0, list);
        this.context = context;
        this.exercicioList = list;
    }

    @Override
    public View getView(final int position, final View convertView, ViewGroup parent) {


        View listItem = convertView;
        if(listItem == null)
            listItem = LayoutInflater.from(context).inflate(R.layout.lista_itens_avaliacao,parent,false);
        final Button btnRecord = listItem.findViewById(R.id.buttonRecord);
        final Button btnStop = listItem.findViewById(R.id.buttonStop);
        final Button btnPlay = listItem.findViewById(R.id.buttonPlay);

        audio = false;
        btnStop.setEnabled(false);
        btnPlay.setEnabled(false);

        btnRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                btnPlay.setEnabled(true);
                btnStop.setEnabled(true);

                if(isAudio()) {
                    playMp3(exercicioList.get(0).getAudio());
                }else{
                    mediaPlayer.stop();
                }


            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Excelente", Toast.LENGTH_LONG).show();

                btnRecord.setEnabled(true);
                btnStop.setEnabled(false);
                btnPlay.setEnabled(true);

            }
        });

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Melhora", Toast.LENGTH_LONG).show();
                btnStop.setEnabled(true);
                btnPlay.setEnabled(false);

            }
        });

        return listItem;
    }


    public boolean isAudio (){

        return this.audio = !this.audio;
    }





    private void playMp3(byte[] mp3SoundByteArray) {

        try {
            // create temp file that will hold byte array
            File tempMp3 = File.createTempFile("audio", "mp3", this.getContext().getCacheDir());
            tempMp3.deleteOnExit();
            FileOutputStream fos = new FileOutputStream(tempMp3);
            fos.write(mp3SoundByteArray);
            fos.close();

            // resetting mediaplayer instance to evade problems
            mediaPlayer.reset();

            // In case you run into issues with threading consider new instance like:
            // MediaPlayer mediaPlayer = new MediaPlayer();

            // Tried passing path directly, but kept getting
            // "Prepare failed.: status=0x1"
            // so using file descriptor instead
            FileInputStream fis = new FileInputStream(tempMp3);
            mediaPlayer.setDataSource(fis.getFD());

            mediaPlayer.prepare();
            mediaPlayer.start();
        } catch (IOException ex) {
            String s = ex.toString();
            ex.printStackTrace();
        }
    }



}
