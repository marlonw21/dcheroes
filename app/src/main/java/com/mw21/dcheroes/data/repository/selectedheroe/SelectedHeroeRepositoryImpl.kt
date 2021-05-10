package com.mw21.dcheroes.data.repository.selectedheroe

import android.util.Log
import com.mw21.dcheroes.data.model.selectedheroe.SelectedHeroe
import com.mw21.dcheroes.data.repository.selectedheroe.datasource.SelectedHeroeLocalDataSource
import com.mw21.dcheroes.data.repository.selectedheroe.datasource.SelectedHeroeRemoteDataSource
import com.mw21.dcheroes.domain.repository.SelectedHeroeRepository
import java.lang.Exception

class SelectedHeroeRepositoryImpl(
    private val selectedHeroeRemoteDataSource: SelectedHeroeRemoteDataSource,
    private val selectedHeroeLocalDataSource: SelectedHeroeLocalDataSource
    ) : SelectedHeroeRepository {

    override suspend fun getSelectedHeroe(heroePath: String): SelectedHeroe? = getSelectedHeroeFromAPI(heroePath)
    override suspend fun getSelectedHeroeFromDB(id: String): SelectedHeroe? = getSelectedHeroeLocalDataSource(id)
    override suspend fun saveHeroeToDB(selectedHeroe: SelectedHeroe) {
        selectedHeroeLocalDataSource.saveSelectedHeroe(selectedHeroe)
    }

    override suspend fun deleteHeroeFromDB(id: String) {
        selectedHeroeLocalDataSource.deleteHeroeFromDB(id)
    }

    suspend fun getSelectedHeroeFromAPI(heroePath: String): SelectedHeroe?{
            var selectedHeroe: SelectedHeroe?=null
        try {
            val response =  selectedHeroeRemoteDataSource.getSelectedHeroe(heroePath)
            val body = response.body()
            if (body != null){
                selectedHeroe = body
                return selectedHeroe
            }
        }catch (exception: Exception){
            Log.d("exception", exception.message.toString())

        }
        return selectedHeroe

    }

    suspend fun getSelectedHeroeLocalDataSource(id: String): SelectedHeroe?{
        var selectedHeroe: SelectedHeroe?=null
        try {
            selectedHeroe = selectedHeroeLocalDataSource.getSelectedHeroeFromDB(id)
        }catch (exception: Exception){
            Log.d("exception", exception.message.toString())
        }
        return selectedHeroe
        /*
        if (selectedHeroe != null){
            return selectedHeroe
        }else{
            val selectedHeroe = getSelectedHeroeFromAPI(id)
            return  selectedHeroe
        }
        return selectedHeroe

         */
    }
}