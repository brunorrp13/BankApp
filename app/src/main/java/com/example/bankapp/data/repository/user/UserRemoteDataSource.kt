package com.example.bankapp.data.repository.user

import com.example.bankapp.data.model.APIResponse
import retrofit2.Response

interface UserRemoteDataSource {

    suspend fun login(user: String, password: String): Response<APIResponse>

}