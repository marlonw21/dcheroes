package com.mw21.dcheroes.presentation.di.core

import androidx.room.Delete
import com.mw21.dcheroes.domain.repository.DcHeroesRepository
import com.mw21.dcheroes.domain.repository.SelectedHeroeRepository
import com.mw21.dcheroes.domain.usecase.*
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun getDcHeroesUseCase(dcHeroesRepository: DcHeroesRepository): GetDcHeroesUseCase{
        return GetDcHeroesUseCase(dcHeroesRepository)
    }

    @Provides
    fun updateDcHeroesUseCase(dcHeroesRepository: DcHeroesRepository): UpdateDcHeroesUseCase{
        return UpdateDcHeroesUseCase(dcHeroesRepository)
    }

    @Provides
    fun getSelectedHeroeUseCase(selectedHeroeRepository: SelectedHeroeRepository): GetSelectedHeroeUsecase = GetSelectedHeroeUsecase(selectedHeroeRepository)

    @Provides
    fun saveHeroToDB(selectedHeroeRepository: SelectedHeroeRepository): SaveHeroToDB = SaveHeroToDB(selectedHeroeRepository)

    @Provides
    fun deleteHeroFromDBUseCase(selectedHeroeRepository: SelectedHeroeRepository): DeleteHeroFromDB = DeleteHeroFromDB(selectedHeroeRepository)
}