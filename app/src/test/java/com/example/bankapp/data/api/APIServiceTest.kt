package com.example.bankapp.data.api


import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okio.buffer
import okio.source
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class APIServiceTest {

    private lateinit var service: APIService
    private lateinit var server: MockWebServer

    @Before
    fun setUp() {
        server = MockWebServer()
        service = Retrofit.Builder()
            .baseUrl(server.url(""))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(APIService::class.java)
    }

    private fun enqueueMockResponse(
      fileName:String
    ){
      val inputStream = javaClass.classLoader!!.getResourceAsStream(fileName)
      val source = inputStream.source().buffer()
      val mockResponse = MockResponse()
      mockResponse.setBody(source.readString(Charsets.UTF_8))
      server.enqueue(mockResponse)

    }

    @Test
    fun getExtrato_sentRequest_receivedExpected(){
        runBlocking {
            enqueueMockResponse("extrato.json")
            val responseBody = service.getExtrato().body()
            val request = server.takeRequest()
            assertThat(responseBody).isNotNull()
            assertThat(request.path).isEqualTo("/extrato")
        }
    }


    @After
    fun tearDown() {
       server.shutdown()
    }
}