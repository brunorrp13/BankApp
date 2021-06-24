package com.example.bankapp.presentation.di

import android.app.Application
import com.example.bankapp.domain.usecase.GetExtratoUseCase
import com.example.bankapp.domain.usecase.LoginUseCase
import com.example.bankapp.presentation.viewmodel.ViewModelFactory
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
  fun provideViewModelFactory(
     application: Application,
     loginUseCase: LoginUseCase,
     getExtratoUseCase: GetExtratoUseCase
  ):ViewModelFactory{
      return ViewModelFactory(
          application,
          loginUseCase,
          getExtratoUseCase
      )
  }

}








