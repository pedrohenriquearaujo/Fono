package com.example.unicap.fono;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.unicap.model.Exercicio;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExercicioAdapter  extends ArrayAdapter<Exercicio> {

    private final Context context;
    private List<Exercicio> exercicioArrayList = new ArrayList<>();


    public ExercicioAdapter(@NonNull Context context, List<Exercicio> list) {
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


       // Date date = posicaoPaciente.getDate();

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
      //  String strDate = dateFormat.format(date);


       // textView.setText(strDate);
       // textView2.setText(strDate);


        textView2.setEnabled(false);
        textView2.setVisibility(View.INVISIBLE);
        progressBar.setVisibility(View.INVISIBLE);


        return listItem;
    }

}
