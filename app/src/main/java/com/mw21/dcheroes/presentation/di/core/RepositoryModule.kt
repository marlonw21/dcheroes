package com.mw21.dcheroes.presentation.di.core

import com.mw21.dcheroes.data.repository.dcheroes.DcHeroesRepositoryImpl
import com.mw21.dcheroes.data.repository.dcheroes.datasource.DcHeroesCacheDataSource
import com.mw21.dcheroes.data.repository.dcheroes.datasource.DcHeroesLocalDataSource
import com.mw21.dcheroes.data.repository.dcheroes.datasource.DcHeroesRemoteDataSource
import com.mw21.dcheroes.data.repository.selectedheroe.SelectedHeroeRepositoryImpl
import com.mw21.dcheroes.data.repository.selectedheroe.datasource.SelectedHeroeLocalDataSource
import com.mw21.dcheroes.data.repository.selectedheroe.datasource.SelectedHeroeRemoteDataSource
import com.mw21.dcheroes.data.repository.selectedheroe.datasourceImpl.SelectedHeroeRemoteDataSourceImpl
import com.mw21.dcheroes.domain.repository.DcHeroesRepository
import com.mw21.dcheroes.domain.repository.SelectedHeroeRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideDcHeroesRepository(
        dcHeroesLocalDataSource: DcHeroesLocalDataSource,
        dcHeroesRemoteDataSource: DcHeroesRemoteDataSource,
        dcHeroesCacheDataSource: DcHeroesCacheDataSource
    ): DcHeroesRepository{
        return DcHeroesRepositoryImpl(dcHeroesCacheDataSource, dcHeroesLocalDataSource, dcHeroesRemoteDataSource)
    }

    @Singleton
    @Provides
    fun provideSelectedHeroeRepository(
        selectedHeroeRemoteDataSource: SelectedHeroeRemoteDataSource,
        selectedHeroeLocalDataSource: SelectedHeroeLocalDataSource
    ): SelectedHeroeRepository = SelectedHeroeRepositoryImpl(selectedHeroeRemoteDataSource,selectedHeroeLocalDataSource)
}