package com.mw21.dcheroes.presentation

import android.app.Application
import com.mw21.dcheroes.BuildConfig
import com.mw21.dcheroes.presentation.di.Injector
import com.mw21.dcheroes.presentation.di.core.*
import com.mw21.dcheroes.presentation.di.dcheroes.DcHeroesSubComponent
import com.mw21.dcheroes.presentation.di.selectedheroe.SelectedHeroeSubComponent

class App: Application(), Injector {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule("https://serverless-marlonw21.vercel.app/api/"))
            .remoteDataModule(RemoteDataModule())
            .build()
    }

    override fun createDcHeroesSubComponent(): DcHeroesSubComponent {
       return appComponent.dcHeroesSubComponent().create()
    }

    override fun createSelectedHeroeSubComponent(): SelectedHeroeSubComponent {
       return appComponent.selectedHeroeSubComponent().create()
    }

}