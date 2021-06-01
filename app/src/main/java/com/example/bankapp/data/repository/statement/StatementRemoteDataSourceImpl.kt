package com.example.bankapp.data.repository.statement

import com.example.bankapp.data.api.StatementsAPIService
import com.example.bankapp.data.model.APIResponse
import retrofit2.Response

class StatementRemoteDataSourceImpl(
    private val statementsAPIService: StatementsAPIService,
    private val userId: Int
) : StatementRemoteDataSource {

    override suspend fun getStatement(): Response<APIResponse> {
       return statementsAPIService.getStatements(userId)
    }

}
