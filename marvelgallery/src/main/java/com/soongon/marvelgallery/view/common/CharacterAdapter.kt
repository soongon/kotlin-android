package com.soongon.marvelgallery.view.common

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.soongon.marvelgallery.R
import com.soongon.marvelgallery.model.MarvelCharacter

class CharacterAdapter(var items: List<MarvelCharacter> = listOf()) : RecyclerView.Adapter<CharacterViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val row = layoutInflater.inflate(R.layout.item_character, parent, false)
        return CharacterViewHolder(row)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.characterImg.loadImage(items[position].imageUrl)
        holder.nameTxt.text = items[position].name
        holder.nameTxt.tag = position
    }

    override fun getItemCount() = items.size

}
