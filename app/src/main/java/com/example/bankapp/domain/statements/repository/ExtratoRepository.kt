package com.example.bankapp.domain.statements.repository

import com.example.bankapp.data.model.Extrato
import com.example.bankapp.data.util.Resource
import kotlinx.coroutines.flow.Flow

interface ExtratoRepository {

    suspend fun getStatement(): Flow<Result<Extrato>>

}