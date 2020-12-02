package com.example.desafiomarvelapi.data.model

import androidx.annotation.Keep
import com.example.desafiomarvelapi.data.model.DataModel
import com.google.gson.annotations.SerializedName

@Keep
data class ResponseModel(
    val code: Int,
    val status: String,
    val copyright: String,
    val attributionText: String,
    @SerializedName("attributionHTML")
    val attributionHtml: String,
    val etag: String,
    val data: DataModel
)