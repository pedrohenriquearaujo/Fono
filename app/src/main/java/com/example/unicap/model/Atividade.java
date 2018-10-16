package com.example.unicap.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.provider.ContactsContract;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Atividade implements Parcelable {



    private String descricao;
    private Date data;
    private Licoes licao;
    private Paciente paciente;
    private ArrayList<Exercicio> exercicioArrayList;

    public Atividade(String descricao, Date data, Licoes licao, Paciente paciente, ArrayList<Exercicio> exercicioArrayList) {
        this.descricao = descricao;
        this.data = data;
        this.licao = licao;
        this.paciente = paciente;
        this.exercicioArrayList = exercicioArrayList;
    }

    public Atividade() {
    }

    public Atividade(String descricao) {
        this.descricao = descricao;
    }

    protected Atividade(Parcel in) {
        descricao = in.readString();
    }

    public static final Creator<Atividade> CREATOR = new Creator<Atividade>() {
        @Override
        public Atividade createFromParcel(Parcel in) {
            return new Atividade(in);
        }

        @Override
        public Atividade[] newArray(int size) {
            return new Atividade[size];
        }
    };

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Licoes getLicao() {
        return licao;
    }

    public void setLicao(Licoes licao) {
        this.licao = licao;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public ArrayList<Exercicio> getExercicioArrayList() {
        return exercicioArrayList;
    }

    public void setExercicioArrayList(ArrayList<Exercicio> exercicioArrayList) {
        this.exercicioArrayList = exercicioArrayList;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(descricao);
    }
}
