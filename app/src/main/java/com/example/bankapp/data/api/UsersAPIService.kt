package com.example.bankapp.data.api

import com.example.bankapp.data.model.LoginResponse
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface UsersAPIService {

    @FormUrlEncoded
    @POST("userLogin")
    suspend fun login(
        @Field("username") user: String,
        @Field("password") password: String,
    ): Response<LoginResponse>

}