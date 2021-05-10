package com.mw21.dcheroes.domain.repository

import com.mw21.dcheroes.data.model.dcheroes.DcHeroes
import com.mw21.dcheroes.data.model.dcheroes.Heroe

interface DcHeroesRepository {
    suspend fun getDcHeroes(): List<Heroe>?
    suspend fun updateDcHeores(): List<Heroe>?
}