package com.example.bankapp.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.bankapp.domain.login.usecase.LoginUseCase

class LoginViewModelFactory (
    private val app: Application,
    private val useCase: LoginUseCase
        ) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return LoginViewModel(
            app,
            useCase
        ) as T
    }
}