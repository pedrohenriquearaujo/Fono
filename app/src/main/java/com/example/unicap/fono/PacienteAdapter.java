package com.example.unicap.fono;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.unicap.Activity.AtividadesActivity;
import com.example.unicap.model.Paciente;

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

        SharedPreferences sharedPreferences = getContext().getSharedPreferences("preferencias", Context.MODE_PRIVATE) ;
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putInt("id",listPaciente.get(position).getId());
        editor.apply();


        cardView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("paciente",posicaoPaciente);
                /*bundle.putInt("idPaciente",posicaoPaciente.getId());
                bundle.putInt("",posicaoPaciente.get);
                bundle.putString("nomePaciente",posicaoPaciente.getNome());
                bundle.putString("idadePaciente",posicaoPaciente.getDataNascimento());
                bundle.putString("descricaoPaciente",posicaoPaciente.getDescricao());*/

                Intent i = new Intent(context.getApplicationContext(),AtividadesActivity.class);
                i.putExtra("paciente",bundle);
                context.getApplicationContext().startActivity(i);
            }
        });

        return listItem;
    }

}
