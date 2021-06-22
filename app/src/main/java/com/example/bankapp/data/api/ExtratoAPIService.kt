package com.example.bankapp.data.api

import com.example.bankapp.data.model.Extrato
import retrofit2.http.GET

interface ExtratoAPIService {

    @GET("extrato")
    suspend fun getExtrato(
    ): Extrato

}