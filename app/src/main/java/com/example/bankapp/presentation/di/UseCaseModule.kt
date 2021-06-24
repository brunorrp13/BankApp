package com.example.bankapp.presentation.di

import com.example.bankapp.data.repository.remote.statement.ExtratoRepository
import com.example.bankapp.data.repository.remote.user.LoginRepository
import com.example.bankapp.domain.usecase.GetExtratoUseCase
import com.example.bankapp.domain.usecase.LoginUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {
   @Singleton
   @Provides
   fun provideLoginUseCase(
       loginRepository: LoginRepository
   ): LoginUseCase {
      return LoginUseCase(loginRepository)
   }

   @Singleton
   @Provides
   fun provideGetExtratoUseCase(
      extratoRepository: ExtratoRepository
   ): GetExtratoUseCase {
      return GetExtratoUseCase(extratoRepository)
   }

}


















