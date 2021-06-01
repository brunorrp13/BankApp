package com.example.bankapp.domain.login.repository

import com.example.bankapp.data.model.APIResponse
import com.example.bankapp.data.util.Resource

interface UserRepository {

    suspend fun login(user: String, password: String): Resource<APIResponse>

}

