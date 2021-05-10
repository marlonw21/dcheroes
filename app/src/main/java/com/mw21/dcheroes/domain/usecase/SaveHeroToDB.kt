package com.mw21.dcheroes.domain.usecase

import com.mw21.dcheroes.data.model.selectedheroe.SelectedHeroe
import com.mw21.dcheroes.domain.repository.SelectedHeroeRepository

class SaveHeroToDB(private val selectedHeroeRepository: SelectedHeroeRepository) {
    suspend fun execute(selectedHeroe: SelectedHeroe){
        selectedHeroeRepository.saveHeroeToDB(selectedHeroe)
    }
}