package com.example.unicap.fono;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.unicap.Activity.DetalhesActivity;
import com.example.unicap.model.Atividade;

import java.util.List;

public class AtividadeAdapter extends ArrayAdapter<Atividade> {

    private Context context;
    private List<Atividade> atividadeList;

    public AtividadeAdapter(@NonNull Context context, List<Atividade> listLicao) {
        super(context, 0, listLicao);
        this.context = context;
        this.atividadeList = listLicao;
    }



    @SuppressLint("SimpleDateFormat")
    @Override
    public View getView(final int position, final View convertView, ViewGroup parent) {
        View listItem = convertView;
        if (listItem == null)
            listItem = LayoutInflater.from(context).inflate(R.layout.lista_itens_exercicios, parent, false);

        final Atividade posicaoAtividade = atividadeList.get(position);

        CardView cardView = listItem.findViewById(R.id.cardAtividade);


        TextView nome = listItem.findViewById(R.id.textNome);

        nome.setText(posicaoAtividade.getLicao().getNome());


        TextView data = listItem.findViewById(R.id.textData);

        data.setText(posicaoAtividade.getDataCriacao());

        ProgressBar progressBar = listItem.findViewById(R.id.progressBar);
        progressBar.setMax(3);
        progressBar.setProgress(2);

        cardView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent i = new Intent(context.getApplicationContext(),DetalhesActivity.class);
                context.startActivity(i);

            }
        });

        return listItem;
    }
}
