package com.mw21.dcheroes.presentation.di.core

import com.mw21.dcheroes.data.repository.dcheroes.datasource.DcHeroesCacheDataSource
import com.mw21.dcheroes.data.repository.dcheroes.datasourceImpl.DcHeroesCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun provideDcHeroesCacheDataSource(): DcHeroesCacheDataSource{
        return DcHeroesCacheDataSourceImpl()
    }
}