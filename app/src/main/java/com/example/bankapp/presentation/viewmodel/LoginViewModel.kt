package com.example.bankapp.presentation.viewmodel

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.lifecycle.*
import com.example.bankapp.data.listener.ValidationListener
import com.example.bankapp.data.model.LoginResponse
import com.example.bankapp.data.model.User
import com.example.bankapp.data.repository.remote.RetrofitClient
import com.example.bankapp.domain.login.usecase.LoginUseCase
import com.example.tasks.service.constants.TaskConstants
import com.example.tasks.service.listener.APIListener
import com.example.tasks.service.repository.local.SecurityPreferences
import kotlinx.coroutines.launch

class LoginViewModel (
    private val app: Application,
    private val loginUseCase: LoginUseCase
        ) : AndroidViewModel(app)  {
    // Data access
    private val mSecurityPreferences = SecurityPreferences(app)

    private val mLogin = MutableLiveData<ValidationListener>()
    val login: LiveData<ValidationListener> = mLogin

    fun doLogin(username: String, password: String) = viewModelScope.launch {
        loginUseCase.execute("teste@teste.com.br", "abc123@", object : APIListener<LoginResponse> {
            override fun onSuccess(result: LoginResponse, statusCode: Int) {
                // Saving data to SharePreferences
                mSecurityPreferences.store(TaskConstants.SHARED.USERNAME, username)
                mSecurityPreferences.store(TaskConstants.SHARED.PASSWORD, password)

                RetrofitClient.addHeaders(result.token)

                print(result.token)
                mLogin.value = ValidationListener()
            }

            override fun onFailure(message: String) {
                if (message.contains("connection", ignoreCase = true)) {
                    mLogin.value = ValidationListener(message)
                } else {
                    mLogin.value = ValidationListener("E-mail and/or password invalid")
                }
            }

        } )

    }

    fun getLogin(): User {

        val username = mSecurityPreferences.get(TaskConstants.SHARED.USERNAME)
        val personKey = mSecurityPreferences.get(TaskConstants.SHARED.PASSWORD)

        val everLogged = (username != "" && personKey != "")

        if(everLogged) {
            return User(username, personKey)
        }
        return User("", "")
    }


    private fun isNetworkAvailable(context: Context?):Boolean{
        if (context == null) return false
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            val capabilities = connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
            if (capabilities != null) {
                when {
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> {
                        return true
                    }
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> {
                        return true
                    }
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> {
                        return true
                    }
                }
            }
        } else {
            val activeNetworkInfo = connectivityManager.activeNetworkInfo
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected) {
                return true
            }
        }
        return false

    }

}