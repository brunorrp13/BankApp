package com.example.bankapp.presentation.di

import com.example.bankapp.presentation.adapter.ExtratoAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AdapterModule {
   @Singleton
   @Provides
   fun provideExtratoAdapter():ExtratoAdapter{
       return ExtratoAdapter()
   }
}