package com.example.unicap.fono;

import android.app.AppComponentFactory;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.unicap.model.Atividade;
import com.example.unicap.model.Licoes;
import com.example.unicap.model.Paciente;
import com.example.unicap.model.Video;

import java.util.ArrayList;

//adicionando exercicio

public class CadAtividade extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_licoes);
        ArrayList<Atividade>  atividadeArrayList = null;
        ListView listView = findViewById(R.id.listViewLicao);

       // if (bundle != null) {
          //  a = (ArrayList<Atividade>) bundle.getSerializable("Paciente");
        //}
    //    Bundle bundle = getIntent().getParcelableArrayListExtra().get("adsf");


         atividadeArrayList =  getIntent().getParcelableArrayListExtra("atividade");



        //final Paciente paciente = p;

        listView.setAdapter(new LicaoAdapter(this, carregarLicoes(),atividadeArrayList));






        // TextView t = findViewById (R.id.nomePaciente);
        //Button button = findViewById (R.id.bt_add_licao);


//        TextView textView = findViewById(R.id.pos_licao);
//
//        Bundle bundle = getIntent().getExtras();
//
//
//        String data = null;
//        if (bundle != null) {
//            data = bundle.getString("licao");
//        }
//
//
//        textView.setText(data);
//
//        Button button = findViewById (R.id.bt_add_licao);
//
//
//
//
//        button.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(getApplicationContext(),LicaoActivity.class); //ir para tela de cadastrar atividade
//                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                getApplicationContext().startActivity(i);
//            }
//        });



    }
    public ArrayList<Licoes> carregarLicoes(){


        ArrayList<Licoes> licoes = new ArrayList<>();

        licoes.add(new Licoes("Nome da Lição 1","Descrição da lição 1",new Video()));

        licoes.add(new Licoes("Nome da Lição 2","Descrição da lição 2",new Video()));

        licoes.add(new Licoes("Nome da Lição 3","Descrição da lição 3",new Video()));

        licoes.add(new Licoes("Nome da Lição 4","Descrição da lição 4",new Video()));

        licoes.add(new Licoes("Nome da Lição 5","Descrição da lição 5",new Video()));


        return licoes;

    }

}
