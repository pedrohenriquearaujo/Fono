package com.example.unicap.Activity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.unicap.Retrofit.Config.RetrofitConfig;
import com.example.unicap.fono.ExercicioAdapter;
import com.example.unicap.fono.R;
import com.example.unicap.model.Atividade;
import com.example.unicap.model.Exercicio;
import com.example.unicap.model.Licao;
import com.example.unicap.model.Paciente;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ExercicioActivity extends AppCompatActivity {

    private Context context;
    private Atividade atividade = new Atividade();
    private List<Exercicio> exercicioList;
    private String dataFormatada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_exercicios);
        atividade = new Atividade();
        exercicioList = new ArrayList<>();

        final EditText hora = findViewById(R.id.textHora);
        final EditText data = findViewById(R.id.textData);

        data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar mcurrentDate = Calendar.getInstance();
                int mYear = mcurrentDate.get(Calendar.YEAR);
                int mMonth = mcurrentDate.get(Calendar.MONTH);
                int mDay = mcurrentDate.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog mDatePicker;
                mDatePicker = new DatePickerDialog(ExercicioActivity.this, new DatePickerDialog.OnDateSetListener() {
                    public void onDateSet(DatePicker datepicker, int selectedyear, int selectedmonth, int selectedday) {
                        selectedmonth = selectedmonth + 1;
                        data.setText("" + selectedday + "/" + selectedmonth + "/" + selectedyear);
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        mcurrentDate.set(selectedyear, selectedmonth - 1, selectedday);
                        dataFormatada = sdf.format(mcurrentDate.getTime());
                    }
                }, mYear, mMonth, mDay);
                mDatePicker.setTitle("Select Date");
                mDatePicker.show();
            }
        });

        hora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mcurrentTime.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(ExercicioActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        hora.setText( selectedHour + ":" + selectedMinute + ":00");
                        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                        mcurrentTime.set(2018,10,25,selectedHour, selectedMinute,0);
                        hora.setText(sdf.format(mcurrentTime.getTime()));
                    }
                }, hour, minute, true);//Yes 24 hour time
                mTimePicker.setTitle("Select Time");
                mTimePicker.show();

            }
        });



        Button bt_concluir = findViewById (R.id.bt_concluir);
        bt_concluir.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("preferencias", Context.MODE_PRIVATE) ;
                int paciente_id = sharedPreferences.getInt("id",0);
                int licao_id = sharedPreferences.getInt("licao_id",0);
                Atividade atividade = new Atividade();
                Licao licao = new Licao();
                licao.setId(licao_id);
                Paciente paciente = new Paciente();
                paciente.setId(1);
                atividade.setLicao(licao);
                atividade.setPaciente(paciente);
                atividade.setExercicios(exercicioList);

                Call<Atividade> call = new RetrofitConfig().getAtividadeService().cadastrarAtividade(atividade);
                call.enqueue(new Callback<Atividade>() {
                    @Override
                    public void onResponse(Call<Atividade> call, Response<Atividade> response) {
                        Log.d("BUG", response.toString());
                        Intent i = new Intent(getApplicationContext(),AtividadesActivity.class); //ir para tela de cadastrar atividade
                        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        getApplicationContext().startActivity(i);
                        Toast.makeText(ExercicioActivity.this, "Sucesso ao Cadastrar", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<Atividade> call, Throwable t) {
                        Toast.makeText(ExercicioActivity.this, "Erro ao Cadastrar", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });

        Button bt_adicionar_exercicio = findViewById (R.id.bt_adicionar_exercicio);
        bt_adicionar_exercicio.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {




                String dataHoraMarcada = dataFormatada + "T" + hora.getText().toString();
                Log.d("DATA", dataHoraMarcada);
                ListView listView = findViewById(R.id.listViewExercicios);



                exercicioList.add(new Exercicio(0, null, null, dataHoraMarcada, null, null));

                atividade.setExercicios(exercicioList);

                listView.setAdapter(new ExercicioAdapter(getApplication(),atividade.getExercicios()));


            }
        });
    }


}
