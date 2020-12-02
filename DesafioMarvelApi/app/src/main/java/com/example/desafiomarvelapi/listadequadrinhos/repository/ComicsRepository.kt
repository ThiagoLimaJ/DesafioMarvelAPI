package com.example.desafiomarvelapi.listadequadrinhos.repository

import com.example.desafiomarvelapi.data.api.ComicsMarvelEndpoint
import com.example.desafiomarvelapi.data.api.PUBLIC_API_KEY
import com.example.desafiomarvelapi.data.api.extensions.getHash
import com.example.desafiomarvelapi.data.api.extensions.getTimeStamp

class ComicsRepository{
    private val client = ComicsMarvelEndpoint.endpoint
    private val comic = "comic"
    suspend fun obterComics() = client.obterComics(
        comic,
        comic,
        true,
        "title",
        12,
        getTimeStamp(),
        getHash(),
        PUBLIC_API_KEY
    )
}