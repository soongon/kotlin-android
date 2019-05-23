package com.soongon.marvelgallery.view.common

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.soongon.marvelgallery.R

class CharacterViewHolder(view: View): RecyclerView.ViewHolder(view) {
    val characterImg: ImageView = view.findViewById(R.id.characterImageView) as ImageView
    val nameTxt: TextView = view.findViewById(R.id.nameTextView) as TextView

    init {
        view.setOnClickListener {
            Toast.makeText(view.context, "event..", Toast.LENGTH_LONG).show()
//            val intent = Intent(view.context, NationDetailActivity::class.java)
//            intent.putExtra("nationName",
//                view.findViewById<TextView>(R.id.nameTextView).text)
//            view.context.startActivity(intent)
        }
    }
}