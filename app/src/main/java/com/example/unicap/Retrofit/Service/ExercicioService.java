package com.example.unicap.Retrofit.Service;

import com.example.unicap.model.Exercicio;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ExercicioService {

    @GET("exercicio/listar")
    Call<List<Exercicio>> GetExercicios();

}
