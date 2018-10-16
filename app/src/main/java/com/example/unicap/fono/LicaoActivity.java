package com.example.unicap.fono;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.unicap.model.Atividade;
import com.example.unicap.model.Licoes;
import com.example.unicap.model.Paciente;

import java.util.ArrayList;

public class LicaoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_licoes);

        Paciente p = null;

        Bundle bundle = getIntent().getExtras();

        if ( bundle != null ){
            p = (Paciente) bundle.getSerializable("ObjLicao");

        }

        final Paciente paciente = p;

        ListView listView;


        listView = findViewById(R.id.listViewLicao);

        listView.setAdapter(new LicaoAdapter(this, carregarLicoes(), new ArrayList<Atividade > ()));


        //listView.setAdapter(new LicaoAdapter(this, carregarLicoes()));


    }


    public ArrayList<Licoes> carregarLicoes(){
        ArrayList<Licoes> listLicoes = new ArrayList<>();
        Licoes pedro, avelino, pitt, matheus;

        pedro = new Licoes( "Lição 1");
        avelino = new Licoes("Lição 2");
        pitt =  new Licoes("Lição 3");
        matheus  = new Licoes("Lição 4");


        listLicoes.add(pedro);
        listLicoes.add(avelino);
        listLicoes.add(pitt);
        listLicoes.add(matheus);



        return listLicoes;


    }


}
