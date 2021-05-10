package com.mw21.dcheroes.presentation.home


import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.mw21.dcheroes.domain.usecase.GetDcHeroesUseCase
import com.mw21.dcheroes.domain.usecase.UpdateDcHeroesUseCase

class HomeViewModel(
    private val getDcHeroesUseCase: GetDcHeroesUseCase,
    private val updateDcHeroesUseCase: UpdateDcHeroesUseCase
): ViewModel() {
    fun getDcHeroes() = liveData {
        val dcHeroesList = getDcHeroesUseCase.execute()
        emit(dcHeroesList)
    }

    fun updateDcHeroes() = liveData {
        val dcHeroesList = updateDcHeroesUseCase.execute()
        emit(dcHeroesList)
    }
}