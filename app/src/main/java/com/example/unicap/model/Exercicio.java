package com.example.unicap.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Exercicio {

    //private Atividade atividade;
    private Date date;
    private Status status;
    private Audio audio;


    public Exercicio() {

    }

    public Exercicio(Date date, Status status, Audio audio) {
        this.date = date;
        this.status = status;
    }

    public Audio getAudio() {
        return audio;
    }

    public void setAudio(Audio audio) {
        this.audio = audio;
    }

    public Date getDate() {



        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }




}
