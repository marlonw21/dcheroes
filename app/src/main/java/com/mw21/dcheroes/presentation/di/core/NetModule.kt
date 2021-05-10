package com.mw21.dcheroes.presentation.di.core

import com.mw21.dcheroes.data.api.DcHeroesService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetModule(private val baseURL: String) {
    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit{
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseURL)
            .build()
    }

    @Singleton
    @Provides
    fun provideDcHeroesService(retrofit: Retrofit): DcHeroesService{
        return retrofit.create(DcHeroesService::class.java)
    }
}