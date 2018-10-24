package com.example.unicap.fono;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.unicap.Retrofit.Config.RetrofitConfig;
import com.example.unicap.model.Atividade;
import com.example.unicap.model.Exercicio;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetalhesActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_detalhes_atividade);


        Call<List<Atividade>> call = new RetrofitConfig().getAtividadeService().listarAtividade();

        call.enqueue(new Callback<List<Atividade>>() {
            @Override
            public void onResponse(Call<List<Atividade>> call, Response<List<Atividade>> response) {

                Atividade atividade = response.body().get(0);

                 List<Exercicio> exercicioList = atividade.getExercicios();



                 ListView listView = findViewById(R.id.listGravacao);

                 listView.setAdapter(new AudioAdapter(getApplicationContext(), exercicioList));

            }

            @Override
            public void onFailure(Call<List<Atividade>> call, Throwable t) {

            }
        });


    }
}
