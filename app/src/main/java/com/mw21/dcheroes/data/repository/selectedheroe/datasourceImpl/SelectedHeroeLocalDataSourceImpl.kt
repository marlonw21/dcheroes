package com.mw21.dcheroes.data.repository.selectedheroe.datasourceImpl

import com.mw21.dcheroes.data.db.DaoHeroes
import com.mw21.dcheroes.data.model.selectedheroe.SelectedHeroe
import com.mw21.dcheroes.data.repository.selectedheroe.datasource.SelectedHeroeLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SelectedHeroeLocalDataSourceImpl(private val daoHeroes: DaoHeroes): SelectedHeroeLocalDataSource {
    override suspend fun getSelectedHeroeFromDB(id: String): SelectedHeroe? = daoHeroes.getSavedHeroe(id)

    override suspend fun getAllHeroesSaved(): List<SelectedHeroe> {
        TODO("Not yet implemented")
    }

    override suspend fun deleteHeroeFromDB(id: String) {
        CoroutineScope(Dispatchers.IO).launch {
            daoHeroes.deleteSavedHeroeFromDB(id)
        }
    }

    override suspend fun saveSelectedHeroe(selectedHeroe: SelectedHeroe) {
        CoroutineScope(Dispatchers.IO).launch {
            daoHeroes.saveSelectedHeroe(selectedHeroe)
        }
    }
}