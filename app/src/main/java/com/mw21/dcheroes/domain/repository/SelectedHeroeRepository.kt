package com.mw21.dcheroes.domain.repository

import com.mw21.dcheroes.data.model.selectedheroe.SelectedHeroe

interface SelectedHeroeRepository {
    suspend fun getSelectedHeroe(heroePath: String): SelectedHeroe?
    suspend fun getSelectedHeroeFromDB(id: String): SelectedHeroe?
    suspend fun saveHeroeToDB(selectedHeroe: SelectedHeroe)
    suspend fun deleteHeroeFromDB(id: String)
}