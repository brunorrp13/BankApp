package com.example.bankapp.data.repository.user

import com.example.bankapp.data.model.LoginResponse
import retrofit2.Response

interface AuthRemote {

    suspend fun login(username: String, password: String): Response<LoginResponse>

}