package com.example.bankapp.data.repository

import com.example.bankapp.data.model.Extrato
import com.example.bankapp.data.model.LoginResponse
import com.example.bankapp.data.util.Resource
import retrofit2.Response

class APIConverter {

    companion object {

        fun responseToResourceLogin(response: Response<LoginResponse>): Resource<LoginResponse> {
            if(response.isSuccessful){
                response.body()?.let{result->
                    return Resource.Success(result)
                }
            }
            return Resource.Error(response.message())
        }


        fun responseToResourceExtrato(response: Response<Extrato>): Resource<Extrato> {
            if(response.isSuccessful){
                response.body()?.let{result->
                    return Resource.Success(result)
                }
            }
            return Resource.Error(response.message())
        }
    }

}