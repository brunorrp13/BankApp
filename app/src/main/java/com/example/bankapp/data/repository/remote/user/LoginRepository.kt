package com.example.bankapp.data.repository.remote.user

import android.content.Context
import com.example.bankapp.R
import com.example.bankapp.data.api.UserAPIService
import com.example.bankapp.data.model.LoginResponse
import com.example.bankapp.data.repository.remote.RetrofitClient
import com.example.tasks.service.constants.TaskConstants
import com.example.tasks.service.listener.APIListener
import com.google.gson.Gson
import okhttp3.RequestBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginRepository(
    context: Context
) {

    val mContext: Context = context
    private val mRemote = RetrofitClient.createService(UserAPIService::class.java)

    fun fail(code: Int) = code != TaskConstants.HTTP.SUCCESS

    fun failRespose(respose: String): String {
        return Gson().fromJson(respose, String::class.java)
    }

    fun login(username: String, password: String, listener: APIListener<LoginResponse>) {
        val call: Call<LoginResponse> = mRemote.login(createJsonRequestBody("username" to username,"password" to password))

        call.enqueue(object : Callback<LoginResponse> {
            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                listener.onFailure(mContext.getString(R.string.ERROR_UNEXPECTED))
            }

            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                val code = response.code()
                if (fail(code)) {
                    listener.onFailure("Error")
                } else {
                    response.body()?.let { listener.onSuccess(it, response.code()) }
                }
            }
        })

    }

    private fun createJsonRequestBody(vararg params: Pair<String, String>) =
        RequestBody.create(
            okhttp3.MediaType.parse("application/json; charset=utf-8"),
            JSONObject(mapOf(*params)).toString())

}