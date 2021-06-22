package com.example.bankapp.data.repository.user

import com.example.bankapp.api.UserAPIService
import com.example.bankapp.data.model.LoginResponse
import retrofit2.Response

class UserRemoteDataSourceImpl (
    private val userAPIService: UserAPIService,
    ): UserRemoteDataSource {

    override suspend fun login(username: String, password: String): Response<LoginResponse> {
        return userAPIService.login(username, password)
    }

}