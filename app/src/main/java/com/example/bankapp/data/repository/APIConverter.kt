package com.example.bankapp.data.repository

import com.example.bankapp.data.model.APIResponse
import com.example.bankapp.data.util.Resource
import retrofit2.Response

class APIConverter {

    companion object {
        fun responseToResource(response: Response<APIResponse>): Resource<APIResponse> {
            if(response.isSuccessful){
                response.body()?.let{result->
                    return Resource.Success(result)
                }
            }
            return Resource.Error(response.message())
        }
    }

}