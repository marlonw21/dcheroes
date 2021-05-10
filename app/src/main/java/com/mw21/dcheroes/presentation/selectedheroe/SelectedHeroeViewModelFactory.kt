package com.mw21.dcheroes.presentation.selectedheroe

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mw21.dcheroes.domain.usecase.DeleteHeroFromDB
import com.mw21.dcheroes.domain.usecase.GetSelectedHeroeUsecase
import com.mw21.dcheroes.domain.usecase.SaveHeroToDB

class SelectedHeroeViewModelFactory(
    private val getSelectedHeroeUsecase: GetSelectedHeroeUsecase,
    private val saveHeroToDB: SaveHeroToDB,
    private val deleteHeroFromDB: DeleteHeroFromDB
    ): ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return SelectedHeroeViewModel(getSelectedHeroeUsecase,saveHeroToDB, deleteHeroFromDB) as T
        }
}