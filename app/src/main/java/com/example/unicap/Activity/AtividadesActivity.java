package com.example.unicap.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.unicap.Retrofit.Config.RetrofitConfig;
import com.example.unicap.fono.AtividadeAdapter;
import com.example.unicap.fono.R;
import com.example.unicap.model.Atividade;
import com.example.unicap.model.Paciente;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AtividadesActivity extends AppCompatActivity {

    private Context context;
    private  List<Atividade> atividadeList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_detalhes_paciente);


        Bundle bundle = getIntent().getBundleExtra("paciente");
        Paciente paciente = resgatarPaciente(bundle);
        detalhesPaciente(paciente);


        Call<List<Atividade>> call = new RetrofitConfig().getAtividadeService().listarAtividade(paciente.getId());

        call.enqueue(new Callback<List<Atividade>>() {
            @Override
            public void onResponse(Call<List<Atividade>> call, Response<List<Atividade>> response) {
                List<Atividade> atividadeList = response.body();
                ListView listView = findViewById(R.id.listViewAtividade);
                listView.setAdapter(new AtividadeAdapter(getApplicationContext(), atividadeList));
            }

            @Override
            public void onFailure(Call<List<Atividade>> call, Throwable t) {
                    Toast.makeText(getApplicationContext(),"FALHOU",Toast.LENGTH_SHORT).show();
            }
        });


        Button button = findViewById (R.id.bt_add_atividade);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),CadastrarAtividadeActivity.class); //ir para tela de cadastrar atividade
              //  i.putParcelableArrayListExtra("atividade", atividadeArrayList);
                getApplicationContext().startActivity(i);
            }
        });
    }

    /*
    public List<Atividade> carregarAtividade(){

        Call<List<Atividade>> call = new RetrofitConfig().getAtividadeService().listarAtividade();


        call.enqueue(new Callback<List<Atividade>>() {
            @Override
            public void onResponse(Call<List<Atividade>> call, Response<List<Atividade>> response) {
                atividadeList = (List<Atividade>) response.body().get(0);
            }

            @Override
            public void onFailure(Call<List<Atividade>> call, Throwable t) {


            }
        });
        return atividadeList;
    }*/

    public Paciente resgatarPaciente(Bundle bundle){
        Serializable s = bundle.getSerializable("paciente");
        Paciente paciente = ((Paciente) s);
        return paciente;
    }
    public void detalhesPaciente(Paciente p){
        TextView txtNomePaciente = (TextView)findViewById(R.id.textNome);
        txtNomePaciente.setText(txtNomePaciente.getText().toString()+p.getNome());
        TextView txtDescicaoPaciente = (TextView)findViewById(R.id.textDescricao);
        txtDescicaoPaciente.setText(txtDescicaoPaciente.getText().toString()+p.getDescricao());
        TextView txtIdadePaciente = (TextView)findViewById(R.id.textIdade);
        txtIdadePaciente.setText(txtIdadePaciente.getText().toString()+p.getDataNascimento());
    }




}
