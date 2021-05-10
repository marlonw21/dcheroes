package com.mw21.dcheroes.presentation.di.core

import android.content.Context
import androidx.room.Room
import com.mw21.dcheroes.data.db.DaoHeroes
import com.mw21.dcheroes.data.db.DcHeroesDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataBaseModule {
    @Singleton
    @Provides
    fun provideDcHeroesDatabase(context: Context): DcHeroesDatabase{
       return Room.databaseBuilder(context, DcHeroesDatabase::class.java, "dcheroesclient")
            .build()
    }

    @Singleton
    @Provides
    fun provideDcHeroesDao(dcHeroesDatabase: DcHeroesDatabase): DaoHeroes{
        return dcHeroesDatabase.DaoHeroes()
    }
}