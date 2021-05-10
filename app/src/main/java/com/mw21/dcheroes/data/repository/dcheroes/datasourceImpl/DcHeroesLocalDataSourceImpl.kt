package com.mw21.dcheroes.data.repository.dcheroes.datasourceImpl

import com.mw21.dcheroes.data.db.DaoHeroes
import com.mw21.dcheroes.data.model.dcheroes.Heroe
import com.mw21.dcheroes.data.repository.dcheroes.datasource.DcHeroesLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DcHeroesLocalDataSourceImpl(private val daoHeroes: DaoHeroes):
    DcHeroesLocalDataSource {
    override suspend fun getDcHeroesFromDB(): List<Heroe> = daoHeroes.getHeroes()

    override suspend fun saveDcHeroestoDB(heroee: List<Heroe>) {
    CoroutineScope(Dispatchers.IO).launch {
        daoHeroes.saveHeroes(heroee)
    }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            daoHeroes.deleteAllHeroes()
        }
    }
}