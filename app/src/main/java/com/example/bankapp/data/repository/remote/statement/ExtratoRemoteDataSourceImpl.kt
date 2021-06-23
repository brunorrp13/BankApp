package com.example.bankapp.data.repository.remote.statement

import com.example.bankapp.data.api.ExtratoAPIService
import com.example.bankapp.data.model.Extrato
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import java.lang.RuntimeException

class ExtratoRemoteDataSourceImpl(
    private val extratoAPIService: ExtratoAPIService
) : ExtratoRemoteDataSource {

    override suspend fun getStatement(): Flow<Result<Extrato>> {
       return flow {
        emit(Result.success(extratoAPIService.getExtrato()))
        }.catch {
        emit(Result.failure(RuntimeException("Something went wrong")))
       }
    }
}
