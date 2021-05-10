package com.mw21.dcheroes.data.repository.dcheroes.datasourceImpl

import com.mw21.dcheroes.data.model.dcheroes.Heroe
import com.mw21.dcheroes.data.repository.dcheroes.datasource.DcHeroesCacheDataSource

class DcHeroesCacheDataSourceImpl:
    DcHeroesCacheDataSource {

    private var heoresList = ArrayList<Heroe>()

    override suspend fun getDcHeroesFromCahce(): List<Heroe> = heoresList

    override suspend fun saveDcHeroestoCache(heroes: List<Heroe>) {
        heoresList.clear()
        heoresList = ArrayList(heroes)
    }
}