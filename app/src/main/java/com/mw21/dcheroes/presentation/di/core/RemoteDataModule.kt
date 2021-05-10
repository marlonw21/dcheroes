package com.mw21.dcheroes.presentation.di.core

import com.mw21.dcheroes.data.api.DcHeroesService
import com.mw21.dcheroes.data.repository.dcheroes.datasource.DcHeroesRemoteDataSource
import com.mw21.dcheroes.data.repository.dcheroes.datasourceImpl.DcHeroesRemoteDataSourceImpl
import com.mw21.dcheroes.data.repository.selectedheroe.datasource.SelectedHeroeRemoteDataSource
import com.mw21.dcheroes.data.repository.selectedheroe.datasourceImpl.SelectedHeroeRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule {

    @Singleton
    @Provides
    fun provideDcHeoresRemoteDataSource(dcHeroesService: DcHeroesService): DcHeroesRemoteDataSource{
        return DcHeroesRemoteDataSourceImpl(
            dcHeroesService
        )
    }

    @Singleton
    @Provides
    fun provideSelectedHeroeRemoteDataSource(dcHeroesService: DcHeroesService): SelectedHeroeRemoteDataSource = SelectedHeroeRemoteDataSourceImpl(dcHeroesService)
}