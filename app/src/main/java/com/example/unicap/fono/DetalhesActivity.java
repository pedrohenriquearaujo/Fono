package com.example.unicap.fono;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.unicap.model.Licoes;

import java.util.ArrayList;

public class DetalhesActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_detalhes_atividade);

        // TextView t = findViewById (R.id.nomePaciente);
        //Button button = findViewById (R.id.bt_add_licao);

        ListView listView;


        listView = findViewById(R.id.listGravacao);

        listView.setAdapter(new AudioAdapter(this, carregarLicoes()));

    }

    public ArrayList<Licoes> carregarLicoes(){
        ArrayList<Licoes> listLicoes = new ArrayList<>();
        Licoes pedro, avelino, pitt, matheus;

        pedro = new Licoes( "Audio 1");
        avelino = new Licoes("Audio 2");
        pitt =  new Licoes("Audio 3");
        matheus  = new Licoes("Audio 4");


        listLicoes.add(pedro);
        listLicoes.add(avelino);
        listLicoes.add(pitt);
        listLicoes.add(matheus);



        return listLicoes;


    }
}
