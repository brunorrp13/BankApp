package com.example.bankapp.data.repository.statement

import com.example.bankapp.data.model.APIResponse
import retrofit2.Response

interface StatementRemoteDataSource {

    suspend fun getStatement():Response<APIResponse>
}