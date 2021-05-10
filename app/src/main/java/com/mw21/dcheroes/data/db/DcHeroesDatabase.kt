package com.mw21.dcheroes.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mw21.dcheroes.data.model.dcheroes.Heroe
import com.mw21.dcheroes.data.model.selectedheroe.SelectedHeroe

@Database(entities = [Heroe::class, SelectedHeroe::class],
version = 1,
exportSchema = false)
abstract class DcHeroesDatabase: RoomDatabase() {
    abstract fun DaoHeroes(): DaoHeroes
}