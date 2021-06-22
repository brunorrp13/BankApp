package com.example.bankapp.data.repository.statement

import com.example.bankapp.data.model.Extrato
import com.example.bankapp.data.model.ExtratoItem
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface ExtratoRemoteDataSource {

    suspend fun getStatement(): Flow<Result<Extrato>>
}