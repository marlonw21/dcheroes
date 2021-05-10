package com.mw21.dcheroes.domain.usecase

import com.mw21.dcheroes.domain.repository.SelectedHeroeRepository

class DeleteHeroFromDB(private val selectedHeroeRepository: SelectedHeroeRepository) {
    suspend fun execute(id: String){
        selectedHeroeRepository.deleteHeroeFromDB(id)
    }
}