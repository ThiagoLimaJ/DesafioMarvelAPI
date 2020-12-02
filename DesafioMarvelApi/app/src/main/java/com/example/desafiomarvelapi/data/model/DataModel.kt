package com.example.desafiomarvelapi.data.model

import androidx.annotation.Keep
import com.example.desafiomarvelapi.data.model.ComicModel

@Keep
data class DataModel(
    val offset: Int,
    val limit: Int,
    val total: Int,
    val count: Int,
    val results: List<ComicModel>
)