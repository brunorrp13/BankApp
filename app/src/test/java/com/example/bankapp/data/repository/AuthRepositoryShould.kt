package com.example.bankapp.data.repository

import com.example.bankapp.data.model.Extrato
import com.example.bankapp.data.repository.statement.ExtratoRemoteDataSource
import com.example.bankapp.data.repository.statement.ExtratoRepositoryImpl
import com.example.bankapp.data.repository.user.AuthRemote
import com.example.bankapp.data.repository.user.AuthRemoteImpl
import com.example.bankapp.data.repository.user.AuthRepositoryImpl
import com.example.bankapp.domain.login.repository.AuthRepository
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import junit.framework.Assert
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test
import petros.efthymiou.groovy.utils.BaseUnitTest
import java.lang.RuntimeException

class AuthRepositoryShould : BaseUnitTest() {

    private val service: AuthRemote = mock()
    private val repository = AuthRepositoryImpl(service)

    @Test
    fun loginFromRemote() = runBlockingTest {
            val username = "teste@teste.com.br"
            val password = "abc123@"

            repository.login(username, password)

            verify(service, times(1)).login(username, password)
    }

}