package com.example.bankapp.domain.login.usecase

import com.example.bankapp.data.model.APIResponse
import com.example.bankapp.data.util.Resource
import com.example.bankapp.domain.login.repository.UserRepository

class LoginUseCase (private val userRepository: UserRepository) {

    suspend fun execute(user: String, password: String): Resource<APIResponse> {

        return userRepository.login(user, password)

    }

}