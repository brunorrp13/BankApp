package com.example.bankapp.presentation.di

import android.app.Application
import com.example.bankapp.domain.login.usecase.LoginUseCase
import com.example.bankapp.presentation.viewmodel.LoginViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class FactoryModule {
    @Singleton
    @Provides
  fun provideLoginViewModelFactory(
     application: Application,
     loginUseCase: LoginUseCase
  ):LoginViewModelFactory{
      return LoginViewModelFactory(
          application,
          loginUseCase
      )
  }

}








