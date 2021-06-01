package com.example.bankapp.data.api

import com.example.bankapp.data.model.APIResponse
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface UsersAPIService {

    @POST("login")
    suspend fun login(
        @Field("user") user: String,
        @Field("password") password: String
    ): Response<APIResponse>


}