package com.example.bankapp.presentation.di

import android.content.Context
import com.example.bankapp.data.repository.remote.statement.ExtratoRepository
import com.example.bankapp.data.repository.remote.user.LoginRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideLoginRepository(
        @ApplicationContext context: Context
    ):LoginRepository{
        return LoginRepository(context)
    }

    @Singleton
    @Provides
    fun provideExtratoRepository(
        @ApplicationContext context: Context
    ): ExtratoRepository{
        return ExtratoRepository(context)
    }
}














