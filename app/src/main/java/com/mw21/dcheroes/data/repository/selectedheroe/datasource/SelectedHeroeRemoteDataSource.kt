package com.mw21.dcheroes.data.repository.selectedheroe.datasource

import com.mw21.dcheroes.data.model.selectedheroe.SelectedHeroe
import retrofit2.Response

interface SelectedHeroeRemoteDataSource {
    suspend fun getSelectedHeroe(heroePath: String): Response<SelectedHeroe>
}