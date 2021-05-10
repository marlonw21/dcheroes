package com.mw21.dcheroes.presentation.di.selectedheroe

import com.mw21.dcheroes.presentation.selectedheroe.SelectedHeroeActivity
import dagger.Subcomponent

@SelectedHeroeScope
@Subcomponent( modules = [
    SelectedHeroemodule::class
])
interface SelectedHeroeSubComponent {
    fun inject(selectedHeroeActivity: SelectedHeroeActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create(): SelectedHeroeSubComponent
    }
}