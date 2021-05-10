package com.mw21.dcheroes.data.model.dcheroes

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Heroe(
    @PrimaryKey
    val id: String,
    val img_logo: String,
    val location: String,
    val name: String
)