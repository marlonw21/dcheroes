package com.mw21.dcheroes.presentation.di.core

import com.mw21.dcheroes.presentation.di.dcheroes.DcHeroesSubComponent
import com.mw21.dcheroes.presentation.di.selectedheroe.SelectedHeroeSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules =[
    AppModule::class,
    CacheDataModule::class,
    DataBaseModule::class,
    LocalDataModule::class,
    NetModule::class,
    RemoteDataModule::class,
    RepositoryModule::class,
    UseCaseModule::class
]
)
interface AppComponent {
    fun dcHeroesSubComponent(): DcHeroesSubComponent.Factory
    fun selectedHeroeSubComponent(): SelectedHeroeSubComponent.Factory
}