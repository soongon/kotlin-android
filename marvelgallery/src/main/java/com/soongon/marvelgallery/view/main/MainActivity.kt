package com.soongon.marvelgallery.view.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.view.Window
import com.soongon.marvelgallery.R
import com.soongon.marvelgallery.model.MarvelCharacter
import com.soongon.marvelgallery.view.common.CharacterAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.layoutManager = GridLayoutManager(this, 2)
        recyclerView.adapter = CharacterAdapter(getDataFromSource())
    }

    private fun getDataFromSource() = listOf(
        MarvelCharacter(name = "3-D Man", imageUrl = "https://i.annihil.us/u/prod/marvel/i/mg/c/e0/535fecbbb9784.jpg"),
        MarvelCharacter(name = "Abomination (Emil Blonsky)", imageUrl = "https://i.annihil.us/u/prod/marvel/i/mg/9/50/4ce18691cbf04.jpg")
    )
}
