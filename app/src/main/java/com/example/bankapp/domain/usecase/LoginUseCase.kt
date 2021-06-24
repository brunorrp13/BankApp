package com.example.bankapp.domain.usecase

import com.example.bankapp.data.model.LoginResponse
import com.example.bankapp.data.repository.remote.user.LoginRepository
import com.example.tasks.service.listener.APIListener

class LoginUseCase (private val loginRepository: LoginRepository) {

    fun execute(user: String, password: String, listener: APIListener<LoginResponse>) = loginRepository.login(user, password, listener)

}