package com.example.desafiomarvelapi.quadrinhoinfo.view

import android.content.Intent
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
import com.example.desafiomarvelapi.ImagemFullActivity
import com.example.desafiomarvelapi.R
import com.example.desafiomarvelapi.data.model.ComicModel
import com.example.desafiomarvelapi.listadequadrinhos.view.ComicsListaAdapter
import com.example.desafiomarvelapi.quadrinhoinfo.repository.ComicRepository
import com.example.desafiomarvelapi.quadrinhoinfo.viewmodel.ComicViewModel
import com.squareup.picasso.Picasso

class ComicInfoFragment : Fragment() {

    private var _listaDeComics = mutableListOf<ComicModel>()

    lateinit var _comicAdapter: ComicsListaAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_comic_info, container, false)
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val id = arguments?.getInt("id")

        val viewModel = ViewModelProvider(
            this,
            ComicViewModel.ComicViewModelFactory(ComicRepository())
        ).get(ComicViewModel::class.java)

        id?.let {identificador ->
            viewModel.obterComic(identificador).observe(viewLifecycleOwner, {
                exibirResultados(it)
            })
        }

        view.findViewById<ImageView>(R.id.imageReturnIcon).setOnClickListener {
            val nav = Navigation.findNavController(view)
            nav.navigate(R.id.action_comicInfoFragment_to_listaFragment)
        }

        view.findViewById<ImageView>(R.id.imageViewComicList).setOnClickListener {

                val nav = Navigation.findNavController(view)
                nav.navigate(R.id.action_comicInfoFragment_to_imagemFullFragment2)

        }
    }



    @RequiresApi(Build.VERSION_CODES.N)
    private fun exibirResultados(it: ComicModel?) {
        val header = view?.findViewById<ImageView>(R.id.imageViewHeader)
        val capa = view?.findViewById<ImageView>(R.id.imageViewComicList)
        val titulo = view?.findViewById<TextView>(R.id.txtTitle)
        val descricao = view?.findViewById<TextView>(R.id.txtDescricao)
        val data = view?.findViewById<TextView>(R.id.txtPublished)
        val preco = view?.findViewById<TextView>(R.id.txtPrice)
        val paginas = view?.findViewById<TextView>(R.id.txtPages)

        if(it!=null){
            var url = "${it.thumbnail.url}.${it.thumbnail.type}"
            Picasso.get()
                .load(url)
                .into(capa)

            url = "${it.images[0].url}.${it.images[0].type}"
            Picasso.get()
                .load(url)
                .into(header)

            titulo?.text = it.title
            data?.text = it.dates[0].date
            preco?.text = it.prices[0].price.toString()
            paginas?.text = it.paginas.toString()
            descricao?.text = Html.fromHtml(it.descricao, Html.FROM_HTML_MODE_COMPACT)
        }

    }
}