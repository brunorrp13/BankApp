package com.example.bankapp.data.repository.remote.statement

import com.example.bankapp.data.api.APIService
import com.example.bankapp.data.model.ExtratoItem
import retrofit2.Response

class ExtratoRemoteDataSourceImpl(
    private val APIService: APIService
) : ExtratoRemoteDataSource {

    override suspend fun getStatement(): Response<List<ExtratoItem>> {
       return APIService.getExtrato()

    }
}
