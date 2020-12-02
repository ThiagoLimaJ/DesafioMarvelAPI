package com.example.desafiomarvelapi.listadequadrinhos.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.desafiomarvelapi.R

import com.example.desafiomarvelapi.data.model.ComicModel

class ComicsListaAdapter(
    private val comicList: MutableList<ComicModel>,
    private val listener :(ComicModel) -> Unit):RecyclerView.Adapter<ComicsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComicsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.comic_item_lista, parent, false)
        return ComicsViewHolder(view)
    }

    override fun onBindViewHolder(holder: ComicsViewHolder, position: Int) {
        val item = comicList[position]
        holder.bind(item)
        holder.itemView.setOnClickListener { listener(item) }
    }

    override fun getItemCount() = comicList.size


}