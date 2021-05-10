package com.mw21.dcheroes.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mw21.dcheroes.domain.usecase.GetDcHeroesUseCase
import com.mw21.dcheroes.domain.usecase.UpdateDcHeroesUseCase

class HomeViewModelFactory(
    private val getDcHeroesUseCase: GetDcHeroesUseCase,
    private val updateDcHeroesUseCase: UpdateDcHeroesUseCase
): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return HomeViewModel(getDcHeroesUseCase, updateDcHeroesUseCase) as T
    }
}