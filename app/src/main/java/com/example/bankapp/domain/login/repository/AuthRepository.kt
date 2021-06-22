package com.example.bankapp.domain.login.repository

import com.example.bankapp.data.model.LoginResponse
import com.example.bankapp.data.util.Resource
import com.example.tasks.service.listener.APIListener

interface AuthRepository {

    suspend fun login(username: String, password: String, listener: APIListener<LoginResponse>)
}

