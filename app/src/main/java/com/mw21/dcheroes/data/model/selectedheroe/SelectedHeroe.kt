package com.mw21.dcheroes.data.model.selectedheroe

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class SelectedHeroe(
    @PrimaryKey
    val id: String,
    val description: String,
    val hero_name: String,
    val img_heroe: String,
    val name: String
)