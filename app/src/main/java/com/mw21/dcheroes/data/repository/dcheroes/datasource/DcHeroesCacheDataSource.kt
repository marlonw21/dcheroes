package com.mw21.dcheroes.data.repository.dcheroes.datasource

import com.mw21.dcheroes.data.model.dcheroes.Heroe

interface DcHeroesCacheDataSource {
    suspend fun getDcHeroesFromCahce(): List<Heroe>
    suspend fun saveDcHeroestoCache(heroes: List<Heroe>)
}