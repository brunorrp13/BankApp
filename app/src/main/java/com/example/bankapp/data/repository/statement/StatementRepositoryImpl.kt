package com.example.bankapp.data.repository.statement

import com.example.bankapp.data.model.APIResponse
import com.example.bankapp.data.repository.APIConverter
import com.example.bankapp.data.util.Resource
import com.example.bankapp.domain.statements.repository.StatementRepository

class StatementRepositoryImpl(
    private val statementRemoteDataSource: StatementRemoteDataSource
): StatementRepository {

    override suspend fun getStatement(): Resource<APIResponse> {
          return APIConverter.responseToResource(
              statementRemoteDataSource.getStatement()
        )
    }

}