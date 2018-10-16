package com.example.unicap.fono;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.unicap.model.Atividade;
import com.example.unicap.model.Audio;
import com.example.unicap.model.Exercicio;
import com.example.unicap.model.Licoes;
import com.example.unicap.model.Paciente;
import com.example.unicap.model.Status;
import com.example.unicap.model.Video;

import java.util.ArrayList;
import java.util.Date;

public class PacientesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pacientes);

        ListView listView;


        listView = findViewById(R.id.listViewPaciente);

        ArrayList<Paciente> pacientes = carregarPacientes();

        listView.setAdapter(new PacienteAdapter(this,pacientes));





    }



    public ArrayList<Paciente> carregarPacientes(){
        ArrayList<Paciente> listPacientes = new ArrayList<>();
        Paciente pedro, avelino, pitt, matheus;




        pedro = new Paciente( "Nome: Pedro Henrique", 24, "M", "");
        avelino = new Paciente("Nome: Avelino Gomes",20,"M","Paciente");
        pitt =  new Paciente("Nome: Lucas Pitt",26,"M","Paciente");
        matheus  = new Paciente("Nome: Matheus Marinho",24,"M","Paciente");


        listPacientes.add(pedro);
        listPacientes.add(avelino);
        listPacientes.add(pitt);
        listPacientes.add(matheus);



        return listPacientes;


    }

}
