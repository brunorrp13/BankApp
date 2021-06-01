package com.example.bankapp.domain.statements.repository

import com.example.bankapp.data.model.APIResponse
import com.example.bankapp.data.util.Resource

interface StatementRepository {

    suspend fun getStatement(): Resource<APIResponse>

}