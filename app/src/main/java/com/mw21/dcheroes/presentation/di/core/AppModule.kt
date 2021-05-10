package com.mw21.dcheroes.presentation.di.core

import android.content.Context
import com.mw21.dcheroes.presentation.di.dcheroes.DcHeroesSubComponent
import com.mw21.dcheroes.presentation.di.selectedheroe.SelectedHeroeSubComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [
DcHeroesSubComponent::class,
SelectedHeroeSubComponent::class
])
class AppModule(private val context: Context) {

    @Singleton
    @Provides
    fun provideApplicationContext(): Context{
        return context.applicationContext
    }

}