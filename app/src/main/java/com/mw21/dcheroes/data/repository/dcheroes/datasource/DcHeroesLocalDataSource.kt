package com.mw21.dcheroes.data.repository.dcheroes.datasource

import com.mw21.dcheroes.data.model.dcheroes.Heroe

interface DcHeroesLocalDataSource {
    suspend fun getDcHeroesFromDB(): List<Heroe>
    suspend fun saveDcHeroestoDB(heroee: List<Heroe>)
    suspend fun clearAll()
}