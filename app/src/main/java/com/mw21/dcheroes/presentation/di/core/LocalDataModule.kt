package com.mw21.dcheroes.presentation.di.core

import com.mw21.dcheroes.data.db.DaoHeroes
import com.mw21.dcheroes.data.repository.dcheroes.datasource.DcHeroesLocalDataSource
import com.mw21.dcheroes.data.repository.dcheroes.datasourceImpl.DcHeroesLocalDataSourceImpl
import com.mw21.dcheroes.data.repository.selectedheroe.datasource.SelectedHeroeLocalDataSource
import com.mw21.dcheroes.data.repository.selectedheroe.datasourceImpl.SelectedHeroeLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun provideDcHeoresLocalDataSource(daoHeroes: DaoHeroes): DcHeroesLocalDataSource {
        return DcHeroesLocalDataSourceImpl(daoHeroes)
    }

    @Singleton
    @Provides
    fun provideSelectedHeroeLocalDataSource(daoHeroes: DaoHeroes): SelectedHeroeLocalDataSource{
        return SelectedHeroeLocalDataSourceImpl(daoHeroes)
    }
}