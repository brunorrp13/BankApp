package com.example.bankapp.domain.login.usecase

import com.example.bankapp.data.model.APIResponse
import com.example.bankapp.data.util.Resource
import com.example.bankapp.domain.login.repository.RemoteUserRepository

class LoginUseCase (private val remoteUserRepository: RemoteUserRepository) {

    suspend fun execute(): Resource<APIResponse> {

        return remoteUserRepository.login()

    }

}