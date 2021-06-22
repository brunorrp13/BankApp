package com.example.bankapp.data.repository.user

import com.example.bankapp.data.model.LoginResponse
import com.example.bankapp.data.repository.APIConverter
import com.example.bankapp.data.util.Resource
import com.example.bankapp.domain.login.repository.AuthRepository
import com.example.tasks.service.listener.APIListener

class AuthRepositoryImpl(
    private val authRemote: AuthRemote
): AuthRepository {

    override suspend fun login(username: String, password: String, listener: APIListener<LoginResponse>) =
       authRemote.login(username, password, listener)

}