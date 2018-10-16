package com.example.unicap.model;



public class Gravacao {


    private Paciente paciente;
    private Atividade atividade;
    private Dias dias;
    private Status status;

    public Gravacao(Paciente paciente, Atividade atividade, Dias dias, Status status) {
        this.paciente = paciente;
        this.atividade = atividade;
        this.dias = dias;
        this.status = status;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Atividade getAtividade() {
        return atividade;
    }

    public void setAtividade(Atividade atividade) {
        this.atividade = atividade;
    }

    public Dias getDias() {
        return dias;
    }

    public void setDias(Dias dias) {
        this.dias = dias;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}


