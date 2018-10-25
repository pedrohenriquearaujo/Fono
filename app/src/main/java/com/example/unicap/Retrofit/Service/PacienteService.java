package com.example.unicap.Retrofit.Service;

import com.example.unicap.model.Paciente;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface PacienteService {

    @GET("paciente/listar")
    Call<List<Paciente>> GetPacientes();

    @POST("paciente")
    Call<Paciente> PostPaciente(@Body Paciente paciente);

}
