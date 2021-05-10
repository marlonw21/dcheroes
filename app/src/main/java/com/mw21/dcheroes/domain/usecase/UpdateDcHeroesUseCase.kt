package com.mw21.dcheroes.domain.usecase

import com.mw21.dcheroes.data.model.dcheroes.Heroe
import com.mw21.dcheroes.domain.repository.DcHeroesRepository

class UpdateDcHeroesUseCase(private val dcHeroesRepository: DcHeroesRepository) {
    suspend fun execute(): List<Heroe>? = dcHeroesRepository.updateDcHeores()
}