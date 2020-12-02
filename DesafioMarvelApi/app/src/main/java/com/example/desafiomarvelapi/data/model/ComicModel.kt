package com.example.desafiomarvelapi.data.model

import com.google.gson.annotations.SerializedName

data class ComicModel(
    val id: Int,
    val title:String,
    @SerializedName("description")
    val descricao: String,
    @SerializedName("pageCount")
    val paginas: Int,
    val dates: List<DateModel>,
    val prices: List<PriceModel>,
    val thumbnail: ThumbnailModel,
    val images: List<ImagesModel>
)