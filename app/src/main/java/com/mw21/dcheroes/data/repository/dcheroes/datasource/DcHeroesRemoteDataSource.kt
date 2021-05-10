package com.mw21.dcheroes.data.repository.dcheroes.datasource

import com.mw21.dcheroes.data.model.dcheroes.DcHeroes
import retrofit2.Response

interface DcHeroesRemoteDataSource {
    suspend fun getDcHeroes(): Response<DcHeroes>
}