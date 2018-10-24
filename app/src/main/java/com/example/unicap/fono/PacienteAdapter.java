package com.example.unicap.fono;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.unicap.model.Paciente;

import java.util.ArrayList;
import java.util.List;

public class PacienteAdapter extends ArrayAdapter<Paciente> {


    private Context context;
    private List<Paciente> listPaciente;

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;



    public PacienteAdapter(@NonNull Context context, List<Paciente> listPaciente) {
        super(context, 0, listPaciente);
        this.context = context;
        this.listPaciente = listPaciente;
    }

    @Override
    public View getView(final int position, final View convertView, ViewGroup parent) {
        View listItem = convertView;
        if (listItem == null)
            listItem = LayoutInflater.from(context).inflate(R.layout.lista_itens_paciente, parent, false);

        final Paciente posicaoPaciente = listPaciente.get(position);


        CardView cardView = listItem.findViewById(R.id.bt_paciente);


        TextView nome = listItem.findViewById(R.id.text_nome);

        nome.setText(posicaoPaciente.getNome());


        TextView idade = listItem.findViewById(R.id.text_idade);

        idade.setText( String.valueOf( "Nascimento: "+ posicaoPaciente.getDataNascimento()));


        SharedPreferences sharedPreferences = getContext().getSharedPreferences("preferencias", Context.MODE_PRIVATE) ;
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putInt("id",listPaciente.get(position).getId());
        editor.apply();





        cardView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent i = new Intent(context.getApplicationContext(),AtividadesActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                context.getApplicationContext().startActivity(i);
            }
        });

        return listItem;
    }

}
