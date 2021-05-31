package com.example.bankapp.domain.statements.usecase

import com.example.bankapp.data.model.APIResponse
import com.example.bankapp.data.util.Resource
import com.example.bankapp.domain.statements.repository.RemoteStatementsRepository

class GetStatementUseCase (private val remoteStatementsRepository: RemoteStatementsRepository) {

    suspend fun execute(): Resource<APIResponse> {

    return remoteStatementsRepository.getStatement()

    }

}