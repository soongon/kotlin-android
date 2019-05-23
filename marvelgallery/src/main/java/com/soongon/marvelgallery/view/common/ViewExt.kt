package com.soongon.marvelgallery.view.common

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loadImage(photoUrl: String) {
    Glide.with(context)
        .load(photoUrl)
        .into(this)
}