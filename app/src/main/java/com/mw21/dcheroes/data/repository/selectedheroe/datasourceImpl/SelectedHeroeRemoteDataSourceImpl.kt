package com.mw21.dcheroes.data.repository.selectedheroe.datasourceImpl

import com.mw21.dcheroes.data.api.DcHeroesService
import com.mw21.dcheroes.data.model.selectedheroe.SelectedHeroe
import com.mw21.dcheroes.data.repository.selectedheroe.datasource.SelectedHeroeRemoteDataSource
import retrofit2.Response

class SelectedHeroeRemoteDataSourceImpl(private val dcHeroesService: DcHeroesService):
    SelectedHeroeRemoteDataSource {
    override suspend fun getSelectedHeroe(heroePath: String): Response<SelectedHeroe> = dcHeroesService.getSelectedHeroe(heroePath)
}