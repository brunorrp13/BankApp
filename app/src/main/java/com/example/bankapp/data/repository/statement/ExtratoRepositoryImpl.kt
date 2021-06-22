package com.example.bankapp.data.repository.statement

import com.example.bankapp.data.model.Extrato
import com.example.bankapp.data.repository.APIConverter
import com.example.bankapp.data.util.Resource
import com.example.bankapp.domain.statements.repository.ExtratoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ExtratoRepositoryImpl(
    private val extratoRemoteDataSource: ExtratoRemoteDataSource
): ExtratoRepository {

    override suspend fun getStatement(): Flow<Result<Extrato>> =
        extratoRemoteDataSource.getStatement().map{
            if(it.isSuccess)
                Result.success(it.getOrNull()!!)
            else
                Result.failure(it.exceptionOrNull()!!)
        }

}