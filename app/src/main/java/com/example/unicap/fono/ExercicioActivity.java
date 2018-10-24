package com.example.unicap.fono;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.unicap.model.Atividade;
import com.example.unicap.model.Exercicio;
import com.example.unicap.model.Status;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExercicioActivity extends AppCompatActivity {

    private Context context;
    private Atividade atividade = new Atividade();
    private List<Exercicio> exercicioList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_exercicios);
        atividade = new Atividade();
        exercicioList = new ArrayList<>();







        Button bt_adicionar_exercicio = findViewById (R.id.bt_adicionar_exercicio);

        Button bt_concluir = findViewById (R.id.bt_concluir);

        bt_concluir.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {




                Intent i = new Intent(getApplicationContext(),AtividadesActivity.class); //ir para tela de cadastrar atividade
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                getApplicationContext().startActivity(i);
            }
        });

        bt_adicionar_exercicio.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                TextView data = findViewById(R.id.textData);

                TextView hora = findViewById(R.id.textHora);

                ListView listView = findViewById(R.id.listViewExercicios);

                data.getText();
                hora.getText();



                SharedPreferences sharedPreferences = getSharedPreferences("preferencias", Context.MODE_PRIVATE) ;



                int id = sharedPreferences.getInt("id",0);
                int licao_id = sharedPreferences.getInt("licao_id",0);



                exercicioList.add(new Exercicio(0, null, "NAO AVALIADO", (String) data.getText(), "", null));

                atividade.setExercicios(exercicioList);




                //ArrayList<Exercicio> arrayList = inserirExercicio(d ,String.valueOf(hora.getText()));

                listView.setAdapter(new ExercicioAdapter(getApplication(),atividade.getExercicios()));




            }
        });
    }



    public void inserirExercicio(String status, String dataHoraMarcada,  int atividade_id){



    }


}
