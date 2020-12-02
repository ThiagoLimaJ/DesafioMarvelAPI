package com.example.desafiomarvelapi.listadequadrinhos.view

import android.annotation.SuppressLint
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.desafiomarvelapi.R

import com.example.desafiomarvelapi.data.model.ComicModel
import com.squareup.picasso.Picasso

class ComicsViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
    private val image = view.findViewById<ImageView>(R.id.imageViewComicList)
    private val id = view.findViewById<TextView>(R.id.txtNumberList)

    @SuppressLint("SetTextI18n")
    fun bind(comic: ComicModel){

        id.text = "#${comic.id}"
        val url = "${comic.thumbnail.url}.${comic.thumbnail.type}"
        Picasso.get()
            .load(url)
            .into(image)
    }
}
