package com.example.bankapp.api

import com.example.bankapp.data.repository.user.UserRemoteDataSource
import com.example.bankapp.data.repository.user.UserRemoteDataSourceImpl
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test

class UserRemoteDataSourceShould {

    private lateinit var userRemoteDataSource: UserRemoteDataSource
    private val api: UserAPIService = mock()

    @Test
    fun loginFromAPI() = runBlockingTest {
        userRemoteDataSource = UserRemoteDataSourceImpl(api)
        val username = "teste@teste.com.br"
        val password = "abc123@"

        userRemoteDataSource.login(username, password)

        verify(api, times(1)).login(username, password)
    }




}