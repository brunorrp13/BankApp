package com.example.bankapp.data.api

import com.example.bankapp.data.model.LoginResponse
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*


interface UserAPIService {

    @Headers("Content-Type: application/json")
    @POST("login")
    fun login(
        @Body user: RequestBody
    ): Call<LoginResponse>

}
