package com.example.bankapp.data.repository

import com.example.bankapp.data.repository.remote.user.LoginRepository
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test
import petros.efthymiou.groovy.utils.BaseUnitTest

class LoginRepositoryShould : BaseUnitTest() {

    private val service: LoginRemote = mock()
    private val repository = LoginRepository(service)

    @Test
    fun loginFromRemote() = runBlockingTest {
            val username = "teste@teste.com.br"
            val password = "abc123@"

            repository.login(username, password)

            verify(service, times(1)).login(username, password)
    }

}