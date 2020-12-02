package com.example.desafiomarvelapi.quadrinhoinfo.repository

import com.example.desafiomarvelapi.data.api.ComicsMarvelEndpoint
import com.example.desafiomarvelapi.data.api.PUBLIC_API_KEY
import com.example.desafiomarvelapi.data.api.extensions.getHash
import com.example.desafiomarvelapi.data.api.extensions.getTimeStamp

class ComicRepository {
    private val client = ComicsMarvelEndpoint.endpoint
    private val comic = "comic"
    suspend fun obterComic(id:Int) = client.obterComic(
        id,
        comic,
        comic,
        false,
        getTimeStamp(),
        getHash(),
        PUBLIC_API_KEY
    )
}