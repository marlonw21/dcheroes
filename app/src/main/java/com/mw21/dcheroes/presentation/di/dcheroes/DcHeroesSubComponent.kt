package com.mw21.dcheroes.presentation.di.dcheroes

import com.mw21.dcheroes.presentation.home.HomeActivity
import dagger.Subcomponent
@DcHeroesScope
@Subcomponent(modules = [
DcHeroesModule::class
])
interface DcHeroesSubComponent {
    fun inject(homeActivity: HomeActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create(): DcHeroesSubComponent
    }
}

