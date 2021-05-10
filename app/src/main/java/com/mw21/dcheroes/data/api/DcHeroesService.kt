package com.mw21.dcheroes.data.api

import com.mw21.dcheroes.data.model.dcheroes.DcHeroes
import com.mw21.dcheroes.data.model.selectedheroe.SelectedHeroe
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface DcHeroesService {

    @GET("dcheroes/")
    suspend fun getDcHeroes(): Response<DcHeroes>

    @GET("dcheroes/{path}")
    suspend fun getSelectedHeroe(@Path ("path") heroePath: String): Response<SelectedHeroe>

}