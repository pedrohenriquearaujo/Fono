package com.example.unicap.Retrofit.Service;


import com.example.unicap.model.Atividade;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AtividadeService {

    @GET("atividade/paciente-id/1")
    Call<List<Atividade>> listarAtividade();

}
