package com.example.unicap.fono;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
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
import java.util.List;

public class AtividadesActivity extends AppCompatActivity {

    private Context context;
    private ArrayList<Atividade> atividadeArrayList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_detalhes_paciente);
        Paciente p = null;


            Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            p = (Paciente) bundle.getSerializable("Paciente");
        }


        this.atividadeArrayList =   getIntent().getParcelableArrayListExtra("ObjFinal");

        if( this.atividadeArrayList == null){

            this.atividadeArrayList = carregarLicoes();

        }else{

            System.out.print("opa");
        }


        ListView listView = findViewById(R.id.listViewAtividade);

        Button button = findViewById (R.id.bt_add_atividade);

        listView.setAdapter(new AtividadeAdapter(this, atividadeArrayList));

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                //

                Intent i = new Intent(getApplicationContext(),CadAtividade.class); //ir para tela de cadastrar atividade
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                i.putParcelableArrayListExtra("atividade", atividadeArrayList);

                getApplicationContext().startActivity(i);
            }
        });
    }



    public ArrayList<Atividade> carregarLicoes(){

        ArrayList<Atividade> atividadeArrayList = new ArrayList<>();
        Atividade pedro, avelino, pitt, matheus, chupeta;

        ArrayList<Exercicio> exercicioArrayList = new ArrayList<>();


        Exercicio e = new Exercicio(new Date(), Status.NAO_AVALIADO, new Audio());


        exercicioArrayList.add(e);
        exercicioArrayList.add(e);
        exercicioArrayList.add(e);
        exercicioArrayList.add(e);
        exercicioArrayList.add(e);

        pedro = new Atividade( "Atividade 1",
                new Date(),
                new Licoes("Nome da Licao 1","Licao Massa 1",
                new Video()),
                new Paciente("Pedro",24,"M","Paciente 1"),
                exercicioArrayList);



        avelino = new Atividade( "Atividade 2",
                new Date(),
                new Licoes("Nome da Licao 2","Licao Massa 2",
                        new Video()),
                new Paciente("Avelino",24,"M","Paciente 2"),
                exercicioArrayList);

        pitt = new Atividade( "Atividade 3",
                new Date(),
                new Licoes("Nome da Licao 3","Licao Massa 3",
                        new Video()),
                new Paciente("Pitt",24,"M","Paciente 3"),
                exercicioArrayList);

        matheus = new Atividade( "Atividade 4",
                new Date(),
                new Licoes("Nome da Licao 4","Licao Massa 4",
                        new Video()),
                new Paciente("Matheus",24,"M","Paciente 4"),
                exercicioArrayList);


        chupeta = new Atividade( "Atividade 5",
                new Date(),
                new Licoes("Nome da Licao 5","Licao Massa 5",
                        new Video()),
                new Paciente("Chupeta",24,"M","Paciente 5"),
                exercicioArrayList);



        atividadeArrayList.add(pedro);
        atividadeArrayList.add(avelino);
        atividadeArrayList.add(pitt);
        atividadeArrayList.add(matheus);
        atividadeArrayList.add(chupeta);

        this.atividadeArrayList = atividadeArrayList;

        return atividadeArrayList;


    }


}
