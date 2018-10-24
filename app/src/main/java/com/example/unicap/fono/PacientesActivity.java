package com.example.unicap.fono;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.example.unicap.Retrofit.Config.RetrofitConfig;
import com.example.unicap.model.Paciente;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PacientesActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pacientes);

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





    }

}
