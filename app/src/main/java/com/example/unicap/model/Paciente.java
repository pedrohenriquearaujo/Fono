package com.example.unicap.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Paciente implements Serializable {

    private String nome;
    private int idade;
    private String sexo;
    private String descricao;
    private ArrayList<Atividade> atividadeArrayList;

    public Paciente(String nome, int idade, String sexo, String descricao) {
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
        this.descricao = descricao;
    }

    public Paciente(String nome, int idade, String sexo, String descricao, ArrayList<Atividade> atividadeArrayList) {
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
        this.descricao = descricao;
        this.atividadeArrayList = atividadeArrayList;
    }

    public ArrayList<Atividade> getAtividadeArrayList() {
        return atividadeArrayList;
    }

    public void setAtividadeArrayList(ArrayList<Atividade> atividadeArrayList) {
        this.atividadeArrayList = atividadeArrayList;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
