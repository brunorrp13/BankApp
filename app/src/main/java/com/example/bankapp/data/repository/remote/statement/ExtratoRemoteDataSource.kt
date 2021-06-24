package com.example.bankapp.data.repository.remote.statement

import com.example.bankapp.data.model.ExtratoItem
import retrofit2.Response

interface ExtratoRemoteDataSource {

    suspend fun getStatement(): Response<List<ExtratoItem>>
}