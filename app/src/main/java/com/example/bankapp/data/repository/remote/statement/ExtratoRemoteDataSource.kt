package com.example.bankapp.data.repository.remote.statement

import com.example.bankapp.data.model.Extrato
import kotlinx.coroutines.flow.Flow

interface ExtratoRemoteDataSource {

    suspend fun getStatement(): Flow<Result<Extrato>>
}