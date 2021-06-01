package com.example.bankapp.data.api

import com.example.bankapp.data.model.APIResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface StatementsAPIService {

    @GET("statements/")
    suspend fun getStatements(
        @Query("idUser")
        idUser: Int
    ): Response<APIResponse>

}