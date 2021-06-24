package com.example.bankapp.data.api

import com.example.bankapp.data.model.ExtratoAPIResponse
import com.example.bankapp.data.model.ExtratoItem
import com.example.bankapp.data.model.LoginResponse
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*


interface APIService {

    @Headers("Content-Type: application/json")
    @POST("login")
    fun login(
        @Body user: RequestBody
    ): Call<LoginResponse>

    @GET("extrato")
    suspend fun getExtrato(
    ): Response<List<ExtratoItem>>
}
