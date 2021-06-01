package com.example.bankapp.data.repository.user

import com.example.bankapp.data.model.APIResponse
import com.example.bankapp.data.repository.APIConverter
import com.example.bankapp.data.util.Resource
import com.example.bankapp.domain.login.repository.UserRepository

class UserRepositoryImpl(
    private val userRemoteDataSource: UserRemoteDataSource
): UserRepository {

    override suspend fun login(user: String, password: String): Resource<APIResponse> {
       return APIConverter.responseToResource (
           userRemoteDataSource.login(user, password)
       )
    }



}