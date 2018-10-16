package com.example.unicap.fono;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.unicap.model.Atividade;
import com.example.unicap.model.Audio;
import com.example.unicap.model.Exercicio;
import com.example.unicap.model.Paciente;
import com.example.unicap.model.Status;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ExercicioActivity extends AppCompatActivity {

    private Context context;
    public ArrayList<Exercicio> arrayList;

    public ArrayList<Exercicio> getArrayList() {
        return arrayList;
    }

    public void setArrayList(ArrayList<Exercicio> arrayList) {
        this.arrayList = arrayList;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_exercicios);
        final ArrayList<Atividade> atividadeArrayList =  (ArrayList) getIntent().getParcelableArrayListExtra("atividadeArrayList");





        Button bt_adicionar_exercicio = findViewById (R.id.bt_adicionar_exercicio);

        Button bt_concluir = findViewById (R.id.bt_concluir);

        bt_concluir.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {




                Intent i = new Intent(getApplicationContext(),AtividadesActivity.class); //ir para tela de cadastrar atividade
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                i.putParcelableArrayListExtra("ObjFinal",atividadeArrayList);
                getApplicationContext().startActivity(i);
            }
        });

        bt_adicionar_exercicio.setOnClickListener(new View.OnClickListener() {

            @SuppressLint("SimpleDateFormat")
            @Override
            public void onClick(View v) {

                TextView data = findViewById(R.id.textData);

                TextView hora = findViewById(R.id.textHora);

                ListView listView = findViewById(R.id.listViewExercicios);

                data.getText();
                hora.getText();

                SimpleDateFormat formato;
                formato = new SimpleDateFormat("dd/MM/yyyy");


                Date d = null;
                try {
                    d = formato.parse(String.valueOf(data.getText()));
                } catch (ParseException e) {
                    e.printStackTrace();
                }


                ArrayList<Exercicio> arrayList = inserirExercicio(d ,String.valueOf(hora.getText()));

                listView.setAdapter(new ExercicioAdapter(getApplication(),arrayList));




            }
        });
    }



    public ArrayList<Exercicio>  inserirExercicio(Date data, String hora){

        if(arrayList == null){
            this.arrayList = new ArrayList<Exercicio>();
        }
        this.arrayList.add(new Exercicio(data,Status.NAO_AVALIADO, new Audio()));


        return this.arrayList;


    }


}
