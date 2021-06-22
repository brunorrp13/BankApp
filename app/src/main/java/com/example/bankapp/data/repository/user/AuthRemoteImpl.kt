package com.example.bankapp.data.repository.user

import android.content.Context
import com.example.bankapp.R
import com.example.bankapp.data.api.UserAPIService
import com.example.bankapp.data.model.LoginResponse
import com.example.bankapp.data.repository.RetrofitClient
import com.example.tasks.service.constants.TaskConstants
import com.example.tasks.service.listener.APIListener
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AuthRemoteImpl (
    context: Context,
    private val userAPIService: UserAPIService
    ): AuthRemote {
    val mContext: Context = context

    private val mRemote = RetrofitClient.createService(UserAPIService::class.java)
    fun fail(code: Int) = code != TaskConstants.HTTP.SUCCESS
    fun failRespose(respose: String): String {
        return Gson().fromJson(respose, String::class.java)
    }

    override suspend fun login(username: String, password: String, listener: APIListener<LoginResponse>) {
        val call: Call<LoginResponse> = mRemote.login(username, password)
        call.enqueue(object : Callback<LoginResponse> {
            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                listener.onFailure(mContext.getString(R.string.ERROR_UNEXPECTED))
            }

            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                val code = response.code()
                if (fail(code)) {
                    listener.onFailure(failRespose(response.errorBody()!!.string()))
                } else {
                    response.body()?.let { listener.onSuccess(it, response.code()) }
                }
            }
        })
    }

}