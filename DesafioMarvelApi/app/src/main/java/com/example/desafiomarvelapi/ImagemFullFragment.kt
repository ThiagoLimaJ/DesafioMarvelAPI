package com.example.desafiomarvelapi

import android.os.Build
import android.os.Bundle
import android.text.Html
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.navigation.Navigation
import com.example.desafiomarvelapi.data.model.ComicModel
import com.example.desafiomarvelapi.listadequadrinhos.view.ComicsListaAdapter
import com.example.desafiomarvelapi.quadrinhoinfo.repository.ComicRepository
import com.example.desafiomarvelapi.quadrinhoinfo.viewmodel.ComicViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_imagem_full.*


class ImagemFullFragment : Fragment() {

    private var _listaDeComics = mutableListOf<ComicModel>()

    lateinit var _comicAdapter: ComicsListaAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_imagem_full, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        view.findViewById<ImageView>(R.id.imgClose).setOnClickListener {

            val nav = Navigation.findNavController(view)
            nav.navigate(R.id.action_imagemFullFragment2_to_comicInfoFragment)

        }

    }

}