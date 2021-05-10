package com.mw21.dcheroes.presentation.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mw21.dcheroes.R
import com.mw21.dcheroes.data.model.dcheroes.Heroe
import com.mw21.dcheroes.databinding.ListItemBinding

class HomeAdapter(private val listener: OnItemClickListener): RecyclerView.Adapter<MyViewHolder>(){
    val heroesList = ArrayList<Heroe>()

    fun setList(heroe: List<Heroe>){
        heroesList.clear()
        heroesList.addAll(heroe)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
       val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ListItemBinding = DataBindingUtil.inflate(layoutInflater, R.layout.list_item, parent, false)
        val holder = MyViewHolder(binding)
        binding.root.setOnClickListener{listener.onItemClick(heroesList[holder.adapterPosition])}
        return holder
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.bind(heroesList[position])
    }

    override fun getItemCount(): Int = heroesList.size
}


class MyViewHolder(val binding: ListItemBinding): RecyclerView.ViewHolder(binding.root){

    fun bind(heroe: Heroe) {
        binding.tvName.text = heroe.name
        binding.tvLocation.text = heroe.location
        val imgHeroe = heroe.img_logo
        Glide.with(binding.imageView.context).load(imgHeroe).into(binding.imageView)
    }
}