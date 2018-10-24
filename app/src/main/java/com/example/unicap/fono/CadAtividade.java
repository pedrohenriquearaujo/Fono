package com.example.unicap.fono;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;

import com.example.unicap.Retrofit.Config.RetrofitConfig;
import com.example.unicap.model.Atividade;
import com.example.unicap.model.Licao;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class CadAtividade extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            setContentView(R.layout.tela_licoes);

        Call<List<Licao>> call = new RetrofitConfig().getLicoesService().GetLicoes();
        call.enqueue(new Callback<List<Licao>>() {
            @Override
            public void onResponse(Call<List<Licao>> call, Response<List<Licao>> response) {

                List<Licao> listLicoes  =  response.body();

                ListView listView = findViewById(R.id.listViewLicao);

                listView.setAdapter(new LicaoAdapter(getApplicationContext(),listLicoes));

            }

            @Override
            public void onFailure(Call<List<Licao>> call, Throwable t) {


            }
        });
    }
}
