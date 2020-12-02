package com.example.desafiomarvelapi.quadrinhoinfo.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.example.desafiomarvelapi.data.model.ComicModel
import com.example.desafiomarvelapi.quadrinhoinfo.repository.ComicRepository
import kotlinx.coroutines.Dispatchers
import java.lang.Exception

class ComicViewModel(
    private val repository: ComicRepository
): ViewModel() {
    lateinit var _comic: ComicModel


    fun obterComic(id:Int) = liveData(Dispatchers.IO){
        try {
            val response = repository.obterComic(id)
            _comic = response.data.results[0]
            emit(_comic)
        }catch (ex: Exception){
            println(ex.message)
        }
    }

    class ComicViewModelFactory(
        private val repository: ComicRepository
    ): ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return ComicViewModel(repository) as T
        }
    }
}