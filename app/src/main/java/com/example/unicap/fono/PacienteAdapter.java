package com.example.unicap.fono;

import android.content.Context;
import android.content.Intent;
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


    public PacienteAdapter(@NonNull Context context, ArrayList<Paciente> listPaciente) {
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

//        Button btnAtividade = listItem.findViewById(R.id.bt_paciente);
//        btnAtividade.setText(posicaoPaciente.getNome());



        CardView cardView = listItem.findViewById(R.id.bt_paciente);


        TextView nome = listItem.findViewById(R.id.text_nome);

        nome.setText(posicaoPaciente.getNome());


        TextView idade = listItem.findViewById(R.id.text_idade);

        idade.setText( String.valueOf( "Idade: "+ posicaoPaciente.getIdade()));




        cardView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent i = new Intent(context.getApplicationContext(),AtividadesActivity.class);
                i.putExtra("Paciente",listPaciente.get(position));

                Toast.makeText(context, listPaciente.get(position).getNome(), Toast.LENGTH_LONG).show();

                context.startActivity(i);
            }
        });

        return listItem;
    }

}
