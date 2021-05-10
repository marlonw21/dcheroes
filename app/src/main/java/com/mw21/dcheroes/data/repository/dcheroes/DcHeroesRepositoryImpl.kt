package com.mw21.dcheroes.data.repository.dcheroes

import android.util.Log
import com.mw21.dcheroes.data.model.dcheroes.Heroe
import com.mw21.dcheroes.data.repository.dcheroes.datasource.DcHeroesCacheDataSource
import com.mw21.dcheroes.data.repository.dcheroes.datasource.DcHeroesLocalDataSource
import com.mw21.dcheroes.data.repository.dcheroes.datasource.DcHeroesRemoteDataSource
import com.mw21.dcheroes.domain.repository.DcHeroesRepository
import java.lang.Exception

class DcHeroesRepositoryImpl(
    private val dcHeroesCacheDataSource: DcHeroesCacheDataSource,
    private val dcHeroesLocalDataSource: DcHeroesLocalDataSource,
    private val dcHeroesRemoteDataSource: DcHeroesRemoteDataSource
): DcHeroesRepository {

    override suspend fun getDcHeroes(): List<Heroe>? = getDcHeroesFromCache()

    override suspend fun updateDcHeores(): List<Heroe>? {
        val newListOfDcHeroes = getDcHeroesFromAPI()
        dcHeroesLocalDataSource.clearAll()
        dcHeroesLocalDataSource.saveDcHeroestoDB(newListOfDcHeroes)
        dcHeroesCacheDataSource.saveDcHeroestoCache(newListOfDcHeroes)
        return newListOfDcHeroes

    }

    suspend fun getDcHeroesFromAPI(): List<Heroe>{
        lateinit var heroesList: List<Heroe>
        try{
            val response = dcHeroesRemoteDataSource.getDcHeroes()
            val body = response.body()
            if (body != null){
                heroesList = body.heroes
            }
        }catch (exception: Exception){
            Log.d("EXception:", exception.message.toString())
        }
        return heroesList
    }

    suspend fun getDcHeroesFromDB(): List<Heroe>{
        lateinit var heroesList: List<Heroe>
        try {
            heroesList = dcHeroesLocalDataSource.getDcHeroesFromDB()
        }catch (exception: Exception){
            Log.d("EXception:", exception.message.toString())
        }
        if (heroesList.isNotEmpty()){
            return heroesList
        }else{
            heroesList = getDcHeroesFromAPI()
            dcHeroesLocalDataSource.saveDcHeroestoDB(heroesList)
        }

        return heroesList
    }

    suspend fun getDcHeroesFromCache(): List<Heroe>{
        lateinit var heroesList: List<Heroe>
        try {
            heroesList = dcHeroesCacheDataSource.getDcHeroesFromCahce()
        }catch (exception: Exception){
            Log.d("EXception:", exception.message.toString())
        }
        if (heroesList.size>0){
            return heroesList
        }else{
            heroesList = getDcHeroesFromDB()
            dcHeroesCacheDataSource.saveDcHeroestoCache(heroesList)
        }
        return heroesList
    }
}