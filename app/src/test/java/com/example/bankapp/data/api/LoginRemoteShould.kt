package com.example.bankapp.data.api

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test

class LoginRemoteShould {

    private lateinit var loginRemote: LoginRemote
    private val api: UserAPIService = mock()

    @Test
    fun loginFromAPI() = runBlockingTest {
        loginRemote = LoginRemoteImpl(api)
        val username = "teste@teste.com.br"
        val password = "abc123@"

        loginRemote.login(username, password)

        verify(api, times(1)).login(username, password)
    }




}