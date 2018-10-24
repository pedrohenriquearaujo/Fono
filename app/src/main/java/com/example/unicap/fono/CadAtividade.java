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




    List<Licao> listLicoes = new ArrayList<>();

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




       // atividadeArrayList =  getIntent().getParcelableArrayListExtra("atividade");



        //final Paciente paciente = p;








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
    public List<Licao> carregarLicoes(){


        Call<List<Licao>> call = new RetrofitConfig().getLicoesService().GetLicoes();


        call.enqueue(new Callback<List<Licao>>() {
            @Override
            public void onResponse(Call<List<Licao>> call, Response<List<Licao>> response) {
                listLicoes = (List<Licao>) response.body().get(0);
            }

            @Override
            public void onFailure(Call<List<Licao>> call, Throwable t) {


            }
        });

        return listLicoes;


    }

}
