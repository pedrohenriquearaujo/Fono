package com.example.unicap.fono;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.unicap.model.Atividade;
import com.example.unicap.model.Licoes;
import com.example.unicap.model.Paciente;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LicaoAdapter extends ArrayAdapter<Licoes> {

    private Context context;
    private List<Licoes> listLicao;
    private ArrayList<Atividade> atividadeArrayList;

    public LicaoAdapter(@NonNull Context context, ArrayList<Licoes> listLicao, ArrayList<Atividade> atividadeArrayList) {
        super(context, 0, listLicao);
        this.context = context;
        this.listLicao = listLicao;
        this.atividadeArrayList = atividadeArrayList;
    }

    @Override
    public View getView(final int position, final View convertView, ViewGroup parent) {
        View listItem = convertView;
        if (listItem == null)
            listItem = LayoutInflater.from(context).inflate(R.layout.lista_itens_licoes, parent, false);

        final Licoes posicaoPaciente = listLicao.get(position);
        //opa

        final CardView cardView = listItem.findViewById(R.id.cardViewLicao);

        TextView textView = listItem.findViewById(R.id.textLicao);
        textView.setText(posicaoPaciente.getDescricao());

        //String descricao, Date data, Licoes licao, Paciente paciente, ArrayList<Exercicio> exercicioArrayList


        cardView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                atividadeArrayList.add(new Atividade("Atividade " + (atividadeArrayList.size() + 1 ),new Date(),posicaoPaciente,null,null));
                Intent intent = new Intent(context.getApplicationContext(),ExercicioActivity.class);


                intent.putParcelableArrayListExtra("atividadeArrayList", atividadeArrayList);

                context.startActivity(intent);
            }
        });

        return listItem;
    }
}
