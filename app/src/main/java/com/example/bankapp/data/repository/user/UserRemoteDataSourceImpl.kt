package com.example.bankapp.data.repository.user

import com.example.bankapp.data.api.UsersAPIService
import com.example.bankapp.data.model.LoginResponse
import retrofit2.Response

class UserRemoteDataSourceImpl (
    private val usersAPIService: UsersAPIService,
    ): UserRemoteDataSource {

    override suspend fun login(username: String, password: String): Response<LoginResponse> {
        return usersAPIService.login(username, password)
    }

}