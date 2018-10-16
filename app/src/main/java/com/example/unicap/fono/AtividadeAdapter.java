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
import android.widget.Toast;

import com.example.unicap.model.Atividade;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AtividadeAdapter extends ArrayAdapter<Atividade> {

    private Context context;
    private List<Atividade> listLicao;

    public AtividadeAdapter(@NonNull Context context, ArrayList<Atividade> listLicao) {
        super(context, 0, listLicao);
        this.context = context;
        this.listLicao = listLicao;
    }



    @SuppressLint("SimpleDateFormat")
    @Override
    public View getView(final int position, final View convertView, ViewGroup parent) {
        View listItem = convertView;
        if (listItem == null)
            listItem = LayoutInflater.from(context).inflate(R.layout.lista_itens_exercicios, parent, false);

        final Atividade posicaoPaciente = listLicao.get(position);
//
//            Button btnAtividade = listItem.findViewById(R.id.bt_licao);
//            btnAtividade.setText(posicaoPaciente.getDescricao());


        CardView cardView = listItem.findViewById(R.id.cardAtividade);


        TextView nome = listItem.findViewById(R.id.textNome);

        nome.setText(posicaoPaciente.getDescricao());


        TextView data = listItem.findViewById(R.id.textData);



        SimpleDateFormat s;
        s = new SimpleDateFormat("dd/M/yyyy");

        Date d = posicaoPaciente.getData();
        if ( d != null ) {

            String date = s.format(posicaoPaciente.getData());

            data.setText(String.format("Data: %s", String.valueOf(date)));
        }


        ProgressBar progressBar = listItem.findViewById(R.id.progressBar);
        progressBar.setMax(3);
        progressBar.setProgress(2);

        cardView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context.getApplicationContext(),DetalhesActivity.class));

            }
        });

        return listItem;
    }
}
