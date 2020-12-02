package com.example.desafiomarvelapi.listadequadrinhos.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.desafiomarvelapi.R
import com.example.desafiomarvelapi.data.model.ComicModel
import com.example.desafiomarvelapi.listadequadrinhos.repository.ComicsRepository
import com.example.desafiomarvelapi.listadequadrinhos.viewmodel.ComicsViewModel


class ListaFragment : Fragment() {

    private var _listaDeComics = mutableListOf<ComicModel>()

    lateinit var _comicAdapter: ComicsListaAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_lista, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recycler = view.findViewById<RecyclerView>(R.id.recycler)
        val manager = GridLayoutManager(view.context, 3)

        _comicAdapter = ComicsListaAdapter(_listaDeComics){
            val bundle = bundleOf("id" to it.id)
            val navControl = Navigation.findNavController(view)
            navControl.navigate(R.id.action_listaFragment_to_comicInfoFragment, bundle)
        }

        recycler.apply {
            adapter = _comicAdapter
            layoutManager = manager
            setHasFixedSize(true)
        }

        val viewModel = ViewModelProvider(
            this,
            ComicsViewModel.ComicsViewModelFactory(ComicsRepository())
        ).get(ComicsViewModel::class.java)

        viewModel.obterComics().observe(viewLifecycleOwner,{
            atribuirDados(it)
        })

    }

    fun atribuirDados(lista: List<ComicModel>){
        if(_listaDeComics.isEmpty()){
            _listaDeComics.addAll(lista)
            _comicAdapter.notifyDataSetChanged()
        }
    }
}