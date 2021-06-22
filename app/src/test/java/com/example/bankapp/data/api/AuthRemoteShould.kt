package com.example.bankapp.data.api

import com.example.bankapp.data.repository.user.AuthRemote
import com.example.bankapp.data.repository.user.AuthRemoteImpl
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test

class AuthRemoteShould {

    private lateinit var authRemote: AuthRemote
    private val api: UserAPIService = mock()

    @Test
    fun loginFromAPI() = runBlockingTest {
        authRemote = AuthRemoteImpl(api)
        val username = "teste@teste.com.br"
        val password = "abc123@"

        authRemote.login(username, password)

        verify(api, times(1)).login(username, password)
    }




}