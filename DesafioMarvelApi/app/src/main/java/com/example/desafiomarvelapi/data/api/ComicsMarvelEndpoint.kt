package com.example.desafiomarvelapi.data.api

import com.example.desafiomarvelapi.data.model.ResponseModel
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ComicsMarvelEndpoint {

    @GET("comics")
    suspend fun obterComics(
        @Query("format") format: String?,
        @Query("formatType") formatType: String?,
        @Query("noVariants") noVariants: Boolean,
        @Query("orderBy") orderBy: String,
        @Query("limit") limit: Int,
        @Query("ts") ts: String?,
        @Query("hash") hash: String?,
        @Query("apikey") apikey: String?
    ): ResponseModel

    @GET("comics/{id}")
    suspend fun obterComic(
        @Path("id") id: Int,
        @Query("format") format: String?,
        @Query("formatType") formatType: String?,
        @Query("noVariants") noVariants: Boolean,
        @Query("ts") ts: String?,
        @Query("hash") hash: String?,
        @Query("apikey") apikey: String?
    ): ResponseModel
    companion object{

        val endpoint: ComicsMarvelEndpoint by lazy {
            NetworkUtils.getRetrofitInstance().create(ComicsMarvelEndpoint::class.java)
        }
    }
}