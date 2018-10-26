package com.example.unicap.model;


import java.io.Serializable;

public class Paciente implements Serializable{

    private int id;

    private String nome;

    private String descricao;

    private String sexo;

    private String dataNascimento;

    public Paciente() {
        super();
    }

    public Paciente(int id, String nome, String descricao, String sexo, String dataNascimento) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", sexo='" + sexo + '\'' +
                ", dataNascimento='" + dataNascimento + '\'' +
                '}';
    }
}
