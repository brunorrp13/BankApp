package com.example.bankapp.data.repository

import com.example.bankapp.data.model.Extrato
import com.example.bankapp.data.repository.remote.statement.ExtratoRemoteDataSource
import com.example.bankapp.data.repository.remote.statement.ExtratoRepositoryImpl
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

class ExtratoRepositoryShould: BaseUnitTest() {

    private val service: ExtratoRemoteDataSource = mock()
    private val extrato = mock<Extrato>()
    private val exception = RuntimeException("Something went wrong")

    @Test
    fun getsExtratoFromService() = runBlockingTest {

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
    fun propagateErros() = runBlockingTest {
        val repository = mockFailureCase()

        Assert.assertEquals(exception, repository.getStatement().first().exceptionOrNull())
    }

    private suspend fun mockFailureCase(): ExtratoRepositoryImpl {
        whenever(service.getStatement()).thenReturn(
            flow {
                emit(Result.failure<Extrato>(exception))
            }
        )

        return ExtratoRepositoryImpl(service)

    }


}