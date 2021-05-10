package com.mw21.dcheroes.domain.usecase

import com.mw21.dcheroes.data.model.selectedheroe.SelectedHeroe
import com.mw21.dcheroes.domain.repository.SelectedHeroeRepository

class GetSelectedHeroeUsecase(private val selectedHeroeRepository: SelectedHeroeRepository) {
    suspend fun execute(heroePath: String): SelectedHeroe? = selectedHeroeRepository.getSelectedHeroe(heroePath)
    suspend fun executeFromDB(id: String): SelectedHeroe? = selectedHeroeRepository.getSelectedHeroeFromDB(id)
}