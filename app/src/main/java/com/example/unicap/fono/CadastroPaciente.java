package com.example.unicap.fono;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;
import com.example.unicap.Retrofit.Config.RetrofitConfig;
import com.example.unicap.model.Paciente;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CadastroPaciente extends AppCompatActivity {

    EditText edtNomePaciente;
    EditText edtDataNascimento;
    EditText edtDescricao;
    RadioButton rdbtn_Masculino;
    RadioButton rdbtn_Feminino;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_paciente);

        inicializarComponentes();

        Paciente paciente = new Paciente();

        String txtNome = edtNomePaciente.getText().toString();
        String txtDesc = edtDescricao.getText().toString();

        paciente.setDescricao(txtDesc);
        paciente.setNome(txtNome);
        paciente.setDataNascimento(parserData(edtDataNascimento.getText().toString()));

        if(rdbtn_Masculino.isChecked())
            paciente.setSexo("Masculino");
        else
            paciente.setSexo("Feminino");

        new RetrofitConfig().getPacienteService().PostPaciente(paciente).enqueue(new Callback<Paciente>() {
            @Override
            public void onResponse(Call<Paciente> call, Response<Paciente> response) {
                Toast.makeText(CadastroPaciente.this, ""+response.body().toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Paciente> call, Throwable t) {
                Toast.makeText(CadastroPaciente.this, "Não cadastrado: "+ t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    public String parserData(String data){
        String dataFormatada;

        data.replace('/','-');

        return data;
    }

    public void inicializarComponentes(){

        rdbtn_Masculino = (RadioButton)findViewById(R.id.rdbtn_SexoMasculino);
        rdbtn_Feminino = (RadioButton)findViewById(R.id.rdbtn_SexoFeminino);
        edtNomePaciente = (EditText)findViewById(R.id.edtTxt_NomePaciente);
        edtDataNascimento = (EditText)findViewById(R.id.edtTxt_NascimentoPaciente);
        edtDescricao = (EditText)findViewById(R.id.edtTxt_DescricaoPaciente);

    }

}
