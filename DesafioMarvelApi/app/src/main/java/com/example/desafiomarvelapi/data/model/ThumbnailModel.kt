package com.example.desafiomarvelapi.data.model

import com.google.gson.annotations.SerializedName

data class ThumbnailModel (
    @SerializedName("path")
    val url: String,
    @SerializedName("extension")
    val type: String
)
