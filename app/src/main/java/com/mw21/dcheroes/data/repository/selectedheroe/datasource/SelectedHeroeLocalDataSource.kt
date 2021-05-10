package com.mw21.dcheroes.data.repository.selectedheroe.datasource

import com.mw21.dcheroes.data.model.selectedheroe.SelectedHeroe
import retrofit2.Response

interface SelectedHeroeLocalDataSource {
    suspend fun getSelectedHeroeFromDB(id: String): SelectedHeroe?
    suspend fun getAllHeroesSaved(): List<SelectedHeroe>
    suspend fun deleteHeroeFromDB(id: String)
    suspend fun saveSelectedHeroe(selectedHeroe: SelectedHeroe)
}