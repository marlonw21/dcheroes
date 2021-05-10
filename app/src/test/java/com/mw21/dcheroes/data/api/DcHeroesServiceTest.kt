package com.mw21.dcheroes.data.api

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

class DcHeroesServiceTest {
    private lateinit var service: DcHeroesService
    private lateinit var server: MockWebServer

    @Before
    fun setUp() {
        server = MockWebServer()
        service =  Retrofit.Builder()
            .baseUrl(server.url(""))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DcHeroesService::class.java)
    }

    private fun enqueueMockResponse(file: String){
        val inputStream = javaClass.classLoader!!.getResourceAsStream(file)
        val source = inputStream.source().buffer()
        val mockResponse = MockResponse()
        mockResponse.setBody(source.readString(Charsets.UTF_8))
        server.enqueue(mockResponse)
    }
    @Test
    fun getDcHeroes_SentRequest_receivedExpected(){
        runBlocking {
            enqueueMockResponse("dcheroesresponse.json")
            val body = service.getDcHeroes()
            val request = server.takeRequest()
            assertThat(body).isNotNull()
            assertThat(request.path).isEqualTo("/dcheroes/")
        }
    }

    @Test
    fun getDcHeroes_receivedResponse_correctSizeOfHeroes(){
        runBlocking {
            enqueueMockResponse("dcheroesresponse.json")
            val body = service.getDcHeroes().body()
            val heroesList = body?.heroes
            assertThat(heroesList?.size).isEqualTo(7)
        }
    }

    @Test
    fun getDcHeroes_receivedResponse_correctContent(){
        runBlocking {
            enqueueMockResponse("dcheroesresponse.json")
            val body = service.getDcHeroes().body()
            val heroesList = body?.heroes
            for (i in 0..heroesList?.size!!.minus(1)){
                assertThat(heroesList?.get(i)).isNotNull()
                assertThat(heroesList?.get(i)?.id).isNotNull()
            }
        }
    }

    @After
    fun tearDown() {
       server.shutdown()
    }
}