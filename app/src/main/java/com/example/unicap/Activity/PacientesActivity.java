package com.example.unicap.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.unicap.Retrofit.Config.RetrofitConfig;
import com.example.unicap.fono.CadastroPaciente;
import com.example.unicap.fono.PacienteAdapter;
import com.example.unicap.fono.R;
import com.example.unicap.model.Paciente;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PacientesActivity extends AppCompatActivity {

    Button btnAdicionarPaciente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pacientes);

        getSupportActionBar().setTitle("Pacientes");

        btnAdicionarPaciente = (Button) findViewById(R.id.btn_adcPaciente);

        Call<List<Paciente>> call = new RetrofitConfig().getPacienteService().GetPacientes();

        call.enqueue(new Callback<List<Paciente>>() {
            @Override
            public void onResponse(Call<List<Paciente>> call, Response<List<Paciente>> response) {

                ListView listView = findViewById(R.id.listViewPaciente);

                List<Paciente> listPacientes = response.body();

                listView.setAdapter(new PacienteAdapter(getApplication(),listPacientes));

            }

            @Override
            public void onFailure(Call<List<Paciente>> call, Throwable t) {
                Toast.makeText(PacientesActivity.this, "Falhou", Toast.LENGTH_SHORT).show();

            }
        });

        btnAdicionarPaciente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirTelaCadastroPaciente();
            }
        });

    }

    public void abrirTelaCadastroPaciente(){
        Intent intent = new Intent(PacientesActivity.this,CadastroPaciente.class);
        startActivity(intent);
    }

}
