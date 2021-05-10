package com.mw21.dcheroes.presentation.home

import com.mw21.dcheroes.data.model.dcheroes.Heroe

interface OnItemClickListener {
    fun onItemClick(heroe: Heroe)
}