package com.example.bankapp.domain.login.repository

import com.example.bankapp.data.model.APIResponse
import com.example.bankapp.data.util.Resource

interface RemoteUserRepository {

    suspend fun login(): Resource<APIResponse>

}

