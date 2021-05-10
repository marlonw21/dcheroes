package com.mw21.dcheroes.data.repository.dcheroes.datasourceImpl

import com.mw21.dcheroes.data.api.DcHeroesService
import com.mw21.dcheroes.data.model.dcheroes.DcHeroes
import com.mw21.dcheroes.data.repository.dcheroes.datasource.DcHeroesRemoteDataSource
import retrofit2.Response

class DcHeroesRemoteDataSourceImpl(private val dcHeroesService: DcHeroesService):
    DcHeroesRemoteDataSource {
    override suspend fun getDcHeroes(): Response<DcHeroes> = dcHeroesService.getDcHeroes()
}