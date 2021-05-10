package com.mw21.dcheroes.presentation.selectedheroe

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.mw21.dcheroes.data.model.selectedheroe.SelectedHeroe
import com.mw21.dcheroes.domain.usecase.DeleteHeroFromDB
import com.mw21.dcheroes.domain.usecase.GetSelectedHeroeUsecase
import com.mw21.dcheroes.domain.usecase.SaveHeroToDB
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SelectedHeroeViewModel(
    private val getSelectedHeroeUsecase: GetSelectedHeroeUsecase,
    private val saveHeroToDB: SaveHeroToDB,
    private val deleteHeroFromDB: DeleteHeroFromDB
    ): ViewModel() {
        fun getSelectedHeroe(heroePath: String) = liveData{
            val selectedHeroe = getSelectedHeroeUsecase.execute(heroePath)
            emit(selectedHeroe)
        }

    fun getSelectedHeroeFromDB(id: String) = liveData{
        val dataDB = getSelectedHeroeUsecase.executeFromDB(id)
        emit(dataDB)
    }

    fun saveHeroToDB(selectedHeroe: SelectedHeroe){
        CoroutineScope(Dispatchers.IO).launch{
            saveHeroToDB.execute(selectedHeroe)
        }
    }

    fun deleteHeroFromDB(id: String){
        CoroutineScope(Dispatchers.IO).launch{
           deleteHeroFromDB.execute(id)
        }
    }
}