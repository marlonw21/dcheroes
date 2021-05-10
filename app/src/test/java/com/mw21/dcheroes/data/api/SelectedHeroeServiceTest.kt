package com.mw21.dcheroes.data.api

import com.google.common.truth.Truth
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

class SelectedHeroeServiceTest {

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
    fun getSelectedHeroe_SentRequest_receivedExpected(){
        runBlocking {
            enqueueMockResponse("selectedheroeresponse.json")
            val response =  service.getSelectedHeroe("batman")
            val request = server.takeRequest()
            Truth.assertThat(response).isNotNull()
            Truth.assertThat(request.path).isEqualTo("/dcheroes/batman")
        }
    }

    @Test
    fun getSelectedHeroe_receivedResponse_correctContent(){
        runBlocking {
            enqueueMockResponse("selectedheroeresponse.json")
            val response =  service.getSelectedHeroe("batman").body()
            assertThat(response?.id).isNotNull()
            assertThat(response?.id).isEqualTo("batman")
            assertThat(response?.img_heroe).isNotEmpty()
        }

    }

    @After
    fun tearDown() {
        server.shutdown()
    }
}