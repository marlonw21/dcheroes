package com.mw21.dcheroes.presentation.di.dcheroes

import com.mw21.dcheroes.domain.usecase.GetDcHeroesUseCase
import com.mw21.dcheroes.domain.usecase.UpdateDcHeroesUseCase
import com.mw21.dcheroes.presentation.home.HomeViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class DcHeroesModule {
    @DcHeroesScope
    @Provides
    fun provideDcHeroesViewModelFactory(
        getDcHeroesUseCase: GetDcHeroesUseCase,
        updateDcHeroesUseCase: UpdateDcHeroesUseCase
    ): HomeViewModelFactory{
        return HomeViewModelFactory(
            getDcHeroesUseCase,
            updateDcHeroesUseCase
        )
    }
}