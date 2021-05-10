package com.mw21.dcheroes.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mw21.dcheroes.data.model.dcheroes.DcHeroes
import com.mw21.dcheroes.data.model.dcheroes.Heroe
import com.mw21.dcheroes.data.model.selectedheroe.SelectedHeroe

@Dao
interface DaoHeroes {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveHeroes(heroes: List<Heroe>)

    @Query("DELETE FROM Heroe")
    suspend fun deleteAllHeroes()

    @Query("SELECT * FROM Heroe")
    suspend fun getHeroes(): List<Heroe>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveSelectedHeroe(selectedHeroe: SelectedHeroe)

    @Query("SELECT * FROM SelectedHeroe WHERE id=:id")
    suspend fun getSavedHeroe(id: String): SelectedHeroe?

    @Query("DELETE FROM SelectedHeroe WHERE id=:id")
    suspend fun deleteSavedHeroeFromDB(id: String)

}