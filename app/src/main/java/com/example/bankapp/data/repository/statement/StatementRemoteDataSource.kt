package com.example.bankapp.data.repository.statement

import com.example.bankapp.data.model.Extrato
import com.example.bankapp.data.model.ExtratoItem
import retrofit2.Response

interface StatementRemoteDataSource {

    suspend fun getStatement():Response<Extrato>
}