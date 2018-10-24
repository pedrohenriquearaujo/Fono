package com.example.unicap.Retrofit.Config;


import com.example.unicap.Retrofit.Service.AtividadeService;
import com.example.unicap.Retrofit.Service.ExercicioService;
import com.example.unicap.Retrofit.Service.LicaoService;
import com.example.unicap.Retrofit.Service.PacienteService;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;


public class RetrofitConfig {

    private final Retrofit retrofit;

    public RetrofitConfig(){
        this.retrofit = new Retrofit.Builder()
                .baseUrl("http://ec2-54-94-212-108.sa-east-1.compute.amazonaws.com:8080/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }

    public AtividadeService getAtividadeService(){
        return this.retrofit.create(AtividadeService.class);
    }

    public PacienteService getPacienteService(){
        return this.retrofit.create(PacienteService.class);
    }

    public LicaoService getLicoesService(){
        return this.retrofit.create(LicaoService.class);
    }

    public ExercicioService getExerciciosService(){
        return this.retrofit.create(ExercicioService.class);
    }
}
