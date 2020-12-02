package com.example.desafiomarvelapi.listadequadrinhos.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.example.desafiomarvelapi.data.model.ComicModel
import com.example.desafiomarvelapi.listadequadrinhos.repository.ComicsRepository
import kotlinx.coroutines.Dispatchers
import java.lang.Exception

class ComicsViewModel(
    private val repository: ComicsRepository
):ViewModel() {

    private var _comics : List<ComicModel> = listOf()

    fun obterComics() = liveData(Dispatchers.IO) {
        try{
            val response = repository.obterComics()
            _comics = response.data.results
            emit(_comics)
        }catch (ex: Exception){
            println(ex.message)
        }
    }

    class ComicsViewModelFactory(
        private val repository: ComicsRepository
    ): ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return ComicsViewModel(repository) as T
        }
    }
}