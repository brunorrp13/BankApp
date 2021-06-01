package com.example.bankapp.data.repository.user

import com.example.bankapp.data.api.UsersAPIService
import com.example.bankapp.data.model.APIResponse
import retrofit2.Response

class UserRemoteDataSourceImpl (
    private val usersAPIService: UsersAPIService,
    ): UserRemoteDataSource {

    override suspend fun login(user: String, password: String): Response<APIResponse> {
        return usersAPIService.login(user, password)
    }


}