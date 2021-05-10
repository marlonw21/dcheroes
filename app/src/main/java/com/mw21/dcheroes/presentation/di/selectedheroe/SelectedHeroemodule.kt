package com.mw21.dcheroes.presentation.di.selectedheroe

import com.mw21.dcheroes.domain.usecase.DeleteHeroFromDB
import com.mw21.dcheroes.domain.usecase.GetSelectedHeroeUsecase
import com.mw21.dcheroes.domain.usecase.SaveHeroToDB
import com.mw21.dcheroes.presentation.selectedheroe.SelectedHeroeViewModelFactory
import dagger.Module
import dagger.Provides


@Module
class SelectedHeroemodule {
    @SelectedHeroeScope
    @Provides
    fun provideSelectedHeroeViewModelFactory(
        getSelectedHeroeUsecase: GetSelectedHeroeUsecase,
        saveHeroToDB: SaveHeroToDB,
        deleteHeroFromDB: DeleteHeroFromDB
    ): SelectedHeroeViewModelFactory{
        return SelectedHeroeViewModelFactory(getSelectedHeroeUsecase,saveHeroToDB, deleteHeroFromDB)
    }
}