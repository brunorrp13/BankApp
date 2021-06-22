package com.example.bankapp.api

import com.example.bankapp.data.model.Extrato
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ExtratoAPIService {

    @GET("extrato")
    suspend fun getExtrato(
    ): Extrato

}