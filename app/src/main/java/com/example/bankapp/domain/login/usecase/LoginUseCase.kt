package com.example.bankapp.domain.login.usecase

import com.example.bankapp.data.model.LoginResponse
import com.example.bankapp.data.util.Resource
import com.example.bankapp.domain.login.repository.AuthRepository
import com.example.tasks.service.listener.APIListener

class LoginUseCase (private val authRepository: AuthRepository) {

    suspend fun execute(user: String, password: String,listener: APIListener<LoginResponse>) = authRepository.login(user, password, listener)

}