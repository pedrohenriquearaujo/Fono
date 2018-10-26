package com.example.unicap.fono;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.unicap.Activity.ExercicioActivity;
import com.example.unicap.model.Licao;

import java.util.List;

public class LicaoAdapter extends ArrayAdapter<Licao> {

    private Context context;
    private List<Licao> listLicao;

    public LicaoAdapter(@NonNull Context context, List<Licao> listLicao) {
        super(context, 0, listLicao);
        this.context = context;
        this.listLicao = listLicao;
    }


    @Override
    public View getView(final int position, final View convertView, ViewGroup parent) {

        View listItem = convertView;

        if (listItem == null)
            listItem = LayoutInflater.from(context).inflate(R.layout.lista_itens_licoes, parent, false);

        final Licao posicaoLicao = listLicao.get(position);
        final CardView cardView = listItem.findViewById(R.id.cardViewLicao);

        TextView textView = listItem.findViewById(R.id.textLicao);
        textView.setText(posicaoLicao.getDescricao());



        SharedPreferences sharedPreferences = getContext().getSharedPreferences("preferencias", Context.MODE_PRIVATE) ;
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putInt("licao_id",listLicao.get(position).getId());
        editor.apply();



        cardView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent i = new Intent(context.getApplicationContext(),ExercicioActivity.class);
                context.startActivity(i);
            }
        });

        return listItem;
    }
}
