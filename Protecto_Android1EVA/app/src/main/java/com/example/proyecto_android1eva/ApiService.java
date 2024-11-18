package com.example.proyecto_android1eva;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {
    @POST("usuarios/login")
    Call<UserResponse> loginUser(@Body UserLogin userLogin);

    @POST("usuarios")
    Call<Void> registerUser(@Body User user);

    @GET("camisetas")
    Call<List<Camiseta>> getCamisetas();

    @GET("camisetas/liga/{liga}") // Filtrar por liga
    Call<List<Camiseta>> getCamisetasByLiga(@Path("liga") String liga);

    @GET("camisetas/equipo/{equipo}") // Filtrar por equipo
    Call<List<Camiseta>> getCamisetasByEquipo(@Path("equipo") String equipo);

    @POST("compras")
    Call<Void> realizarCompra(@Body Compra compra);

    @GET("valoraciones/top")
    Call<List<Camiseta>> getTopVendidas();

    @GET("historial-compras/{id_usuario}")
    Call<List<Historial_Compra>> getHistorialCompras(@Path("id_usuario") int idUsuario);




}

