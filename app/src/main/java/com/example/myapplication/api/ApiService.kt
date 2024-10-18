package com.example.myapplication.api

import com.example.myapplication.Model.Prontuario
import com.example.myapplication.Model.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("api/cadastro")
    fun signup(@Body user: User): Call<Void>

    @POST("api/login")
    fun login(@Body credentials: Map<String, String>): Call<Void>

    @POST("api/prontuario")
    fun enviarProntuario(@Body prontuario: Prontuario): Call<Void>

}
