package com.example.unicap.model;

import android.media.MediaPlayer;

import java.io.IOException;

public class Audio {

    private MediaPlayer mp;
    private String filename;


    public void setFilename(String filename) {
        this.filename = filename;
    }

    public void playAudio() {

        try {

            mp = new MediaPlayer();
            mp.setDataSource(filename);
            mp.prepare();
            mp.start();

            mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    try {

                        mp.stop();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });

        } catch (IOException e) {

            //do something
        }

    }


}
