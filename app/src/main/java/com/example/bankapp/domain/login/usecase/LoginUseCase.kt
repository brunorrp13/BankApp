package com.example.bankapp.domain.login.usecase

import com.example.bankapp.data.model.LoginResponse
import com.example.bankapp.data.util.Resource
import com.example.bankapp.domain.login.repository.AuthRepository

class LoginUseCase (private val authRepository: AuthRepository) {

    suspend fun execute(user: String, password: String): Resource<LoginResponse> {

        return authRepository.login(user, password)

    }

}