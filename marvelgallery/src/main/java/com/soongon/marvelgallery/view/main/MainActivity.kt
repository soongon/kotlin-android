package com.soongon.marvelgallery.view.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import android.view.Window
import com.soongon.marvelgallery.R
import com.soongon.marvelgallery.data.MarvelRepositoryImpl
import com.soongon.marvelgallery.model.MarvelCharacter
import com.soongon.marvelgallery.view.common.CharacterAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.layoutManager = GridLayoutManager(this, 2)

        val repo = MarvelRepositoryImpl()
        repo.getAllCharacters()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe ({ items ->
                items.forEach {
                    Log.i("JSON", it.toString())
                }
                //recyclerView.adapter = CharacterAdapter(list)
            }, {
                Log.i("JSON", it.toString())
            })

    }

    private fun getDataFromSource() = listOf(
        MarvelCharacter(name = "3-D Man", imageUrl = "https://i.annihil.us/u/prod/marvel/i/mg/c/e0/535fecbbb9784.jpg"),
        MarvelCharacter(name = "Abomination (Emil Blonsky)", imageUrl = "https://i.annihil.us/u/prod/marvel/i/mg/9/50/4ce18691cbf04.jpg")
    )
}
