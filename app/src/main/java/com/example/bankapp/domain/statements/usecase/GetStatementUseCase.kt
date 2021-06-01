package com.example.bankapp.domain.statements.usecase

import com.example.bankapp.data.model.APIResponse
import com.example.bankapp.data.util.Resource
import com.example.bankapp.domain.statements.repository.StatementRepository

class GetStatementUseCase (private val statementRepository: StatementRepository) {

    suspend fun execute(): Resource<APIResponse> {

    return statementRepository.getStatement()

    }

}