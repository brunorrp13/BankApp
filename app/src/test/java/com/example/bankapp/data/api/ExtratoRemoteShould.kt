package com.example.bankapp.data.api

import com.example.bankapp.data.model.Extrato
import com.example.bankapp.data.repository.statement.ExtratoRemoteDataSource
import com.example.bankapp.data.repository.statement.ExtratoRemoteDataSourceImpl
import com.example.bankapp.data.repository.statement.ExtratoRepositoryImpl
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import junit.framework.Assert
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test
import java.lang.RuntimeException

class ExtratoRemoteShould {

    private lateinit var service: ExtratoRemoteDataSource
    private val api: ExtratoAPIService = mock()
    private val extrato: Extrato = mock<Extrato>()
    private val exception = RuntimeException("Something went wrong")

    @Test
    fun getExtratoFromService() = runBlockingTest {

        val repository = mockSuccessfulCase()

        repository.getStatement()

        verify(service, times(1)).getStatement()
    }



    private suspend fun mockSuccessfulCase(): ExtratoRepositoryImpl {

        whenever(service.getStatement()).thenReturn(

            flow {
                emit(Result.success(extrato))
            }
        )

        return ExtratoRepositoryImpl(service)
    }

    @Test
    fun emitsErrorResultWhenNetworkFails() = runBlockingTest {
        mockErrorCase()

        Assert.assertEquals(
            "Something went wrong",
            service.getStatement().first().exceptionOrNull()?.message
        )
    }

    private suspend fun mockErrorCase() {
        whenever(api.getExtrato()).thenThrow(RuntimeException("Something went wrong"))

        service = ExtratoRemoteDataSourceImpl(api)
    }
}