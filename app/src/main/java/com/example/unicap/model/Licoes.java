package com.example.unicap.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Licoes implements Parcelable {

    private String nome;
    private String descricao;
    private Video video;

    public Licoes(String nome, String descricao, Video video) {
        this.nome = nome;
        this.descricao = descricao;
        this.video = video;
    }

    public Licoes(String descricao) {
        this.descricao = descricao;
    }

    protected Licoes(Parcel in) {
        nome = in.readString();
        descricao = in.readString();
    }

    public static final Creator<Licoes> CREATOR = new Creator<Licoes>() {
        @Override
        public Licoes createFromParcel(Parcel in) {
            return new Licoes(in);
        }

        @Override
        public Licoes[] newArray(int size) {
            return new Licoes[size];
        }
    };

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nome);
        dest.writeString(descricao);
    }
}
