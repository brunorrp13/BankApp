package com.example.bankapp.data.repository.user

import com.example.bankapp.data.model.LoginResponse
import com.example.bankapp.data.repository.APIConverter
import com.example.bankapp.data.util.Resource
import com.example.bankapp.domain.login.repository.AuthRepository

class AuthRepositoryImpl(
    private val authRemote: AuthRemote
): AuthRepository {

    override suspend fun login(username: String, password: String): Resource<LoginResponse> {
       return APIConverter.responseToResourceLogin (
           authRemote.login(username, password)
       )
    }

}