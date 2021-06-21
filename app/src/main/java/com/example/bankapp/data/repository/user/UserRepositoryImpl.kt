package com.example.bankapp.data.repository.user

import com.example.bankapp.data.model.LoginResponse
import com.example.bankapp.data.repository.APIConverter
import com.example.bankapp.data.util.Resource
import com.example.bankapp.domain.login.repository.UserRepository

class UserRepositoryImpl(
    private val userRemoteDataSource: UserRemoteDataSource
): UserRepository {

    override suspend fun login(username: String, password: String): Resource<LoginResponse> {
       return APIConverter.responseToResourceLogin (
           userRemoteDataSource.login(username, password)
       )
    }

}