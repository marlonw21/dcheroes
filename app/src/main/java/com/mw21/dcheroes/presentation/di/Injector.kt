package com.mw21.dcheroes.presentation.di

import com.mw21.dcheroes.presentation.di.dcheroes.DcHeroesSubComponent
import com.mw21.dcheroes.presentation.di.selectedheroe.SelectedHeroeSubComponent

interface Injector {
    fun createDcHeroesSubComponent(): DcHeroesSubComponent
    fun createSelectedHeroeSubComponent(): SelectedHeroeSubComponent
}