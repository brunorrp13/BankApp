package com.example.bankapp.domain.login.repository

import com.example.bankapp.data.model.LoginResponse
import com.example.bankapp.data.util.Resource

interface UserRepository {

    suspend fun login(username: String, password: String): Resource<LoginResponse>

}

