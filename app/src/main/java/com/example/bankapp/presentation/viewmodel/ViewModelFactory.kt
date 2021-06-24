package com.example.bankapp.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.bankapp.domain.usecase.GetExtratoUseCase
import com.example.bankapp.domain.usecase.LoginUseCase

class ViewModelFactory (
    private val app: Application,
    private val loginUseCase: LoginUseCase,
    private val extratoUseCase: GetExtratoUseCase
        ) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ViewModel(
            app,
            loginUseCase,
            extratoUseCase
        ) as T
    }
}