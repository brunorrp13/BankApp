package com.example.bankapp.domain.statements.usecase

import com.example.bankapp.data.model.Extrato
import com.example.bankapp.data.util.Resource
import com.example.bankapp.domain.statements.repository.StatementRepository

class GetStatementUseCase (private val statementRepository: StatementRepository) {

    suspend fun execute(): Resource<Extrato> {

    return statementRepository.getStatement()

    }

}