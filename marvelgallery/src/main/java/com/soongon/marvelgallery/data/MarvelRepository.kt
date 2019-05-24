package com.soongon.marvelgallery.data

import com.soongon.marvelgallery.model.MarvelCharacter
import io.reactivex.Single

interface MarvelRepository {

    fun getAllCharacters(): Single<List<MarvelCharacter>>
}