package com.example.bankapp.data.repository.remote.statement

import android.content.Context
import com.example.bankapp.data.api.APIService
import com.example.bankapp.data.model.ExtratoItem
import com.example.bankapp.data.repository.remote.BaseRepository
import com.example.bankapp.data.repository.remote.RetrofitClient
import com.example.bankapp.data.util.Resource
import retrofit2.Response

class ExtratoRepository(
    context: Context
): BaseRepository(context) {

    private val mRemote = RetrofitClient.createService(APIService::class.java)

    suspend fun getStatement(): Resource<List<ExtratoItem>> {
         return responseToResource(mRemote.getExtrato())
    }

    private fun responseToResource(response: Response<List<ExtratoItem>>): Resource<List<ExtratoItem>> {
        if(response.isSuccessful){
            response.body()?.let {result ->
                return Resource.Success(result)
            }
        }
        return Resource.Error(response.message())
    }


}