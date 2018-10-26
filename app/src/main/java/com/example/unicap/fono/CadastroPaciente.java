package com.example.unicap.fono;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
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

    Button cadastrar;

    Paciente paciente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_paciente);

        inicializarComponentes();

        getSupportActionBar().setTitle("Cadastro de Pacientes");


        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                paciente = new Paciente();

                String txtNome = edtNomePaciente.getText().toString();
                if(txtNome.length()==0) {
                    Toast.makeText(CadastroPaciente.this, "Digite um nome de Paciente", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(edtDataNascimento.getText().toString().length()!=10){
                    Toast.makeText(CadastroPaciente.this, "Digite uma data de Nascimento", Toast.LENGTH_SHORT).show();
                    return;
                }

                String txtDesc = edtDescricao.getText().toString();

                paciente.setDescricao(txtDesc);
                paciente.setNome(txtNome);
                paciente.setDataNascimento(parserData(edtDataNascimento.getText().toString()));


                if(rdbtn_Masculino.isChecked())
                    paciente.setSexo("M");
                else
                    paciente.setSexo("F");

                Log.d("XUPETA",paciente.toString());

                new RetrofitConfig().getPacienteService().PostPaciente(paciente).enqueue(new Callback<Paciente>() {
                    @Override
                    public void onResponse(Call<Paciente> call, Response<Paciente> response) {
                        if(response.code()==400)
                            Toast.makeText(CadastroPaciente.this, "Formato não aceito", Toast.LENGTH_SHORT).show();
                        else if(response.code()==200)
                            Toast.makeText(CadastroPaciente.this, "Paciente cadastrado com Sucesso", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<Paciente> call, Throwable t) {
                        Toast.makeText(CadastroPaciente.this, "Não cadastrado: "+ t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });


    }

    public String parserData(String data){
        String dataFormatada;

        dataFormatada= data.substring(6,10);
        dataFormatada+="-";
        dataFormatada+=data.substring(3,5);
        dataFormatada+="-";
        dataFormatada+=data.substring(0,2);

        return dataFormatada;
    }

    public void inicializarComponentes(){

        rdbtn_Masculino = (RadioButton)findViewById(R.id.rdbtn_SexoMasculino);
        rdbtn_Feminino = (RadioButton)findViewById(R.id.rdbtn_SexoFeminino);
        edtNomePaciente = (EditText)findViewById(R.id.edtTxt_NomePaciente);
        edtDataNascimento = (EditText)findViewById(R.id.edtTxt_NascimentoPaciente);
        edtDescricao = (EditText)findViewById(R.id.edtTxt_DescricaoPaciente);
        cadastrar = (Button)findViewById(R.id.btn_CadastrarPaciente);

    }

}
