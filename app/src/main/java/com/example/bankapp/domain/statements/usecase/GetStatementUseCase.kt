package com.example.bankapp.domain.statements.usecase

import com.example.bankapp.data.model.Extrato
import com.example.bankapp.data.util.Resource
import com.example.bankapp.domain.statements.repository.ExtratoRepository
import kotlinx.coroutines.flow.Flow

class GetStatementUseCase (private val extratoRepository: ExtratoRepository) {

    suspend fun execute(): Flow<Result<Extrato>> {

    return extratoRepository.getStatement()

    }

}