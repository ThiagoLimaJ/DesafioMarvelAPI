package com.example.desafiomarvelapi.data.model

import com.google.gson.annotations.SerializedName

data class ImagesModel(
    @SerializedName("path")
    val url: String,
    @SerializedName("extension")
    val type :String
)