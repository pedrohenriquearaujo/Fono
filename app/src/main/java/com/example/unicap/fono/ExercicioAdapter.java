package com.example.unicap.fono;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.unicap.model.Exercicio;
import com.example.unicap.model.Licoes;

import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ExercicioAdapter  extends ArrayAdapter<Exercicio> {

    private final Context context;
    private List<Exercicio> exercicioArrayList = new ArrayList<>();


    public ExercicioAdapter(@NonNull Context context, ArrayList<Exercicio> list) {
        super(context, 0, list);
        this.context = context;
        this.exercicioArrayList = list;
    }

    @SuppressLint("SimpleDateFormat")
    @Override
    public View getView(final int position, final View convertView, ViewGroup parent) {
        View listItem = convertView;
        if (listItem == null)
            listItem = LayoutInflater.from(context).inflate(R.layout.lista_itens_exercicios, parent, false);

        final Exercicio posicaoPaciente = exercicioArrayList.get(position);
        //opa

        final ListView listView = listItem.findViewById(R.id.listViewExercicios);

        TextView textView = listItem.findViewById(R.id.textNome);

        TextView textView2 = listItem.findViewById(R.id.textData);

        ProgressBar progressBar = listItem.findViewById(R.id.progressBar);


        Date date = posicaoPaciente.getDate();

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String strDate = dateFormat.format(date);


        textView.setText(strDate);
        textView2.setText(strDate);


        textView2.setEnabled(false);
        textView2.setVisibility(View.INVISIBLE);
        progressBar.setVisibility(View.INVISIBLE);


        return listItem;
    }

}
