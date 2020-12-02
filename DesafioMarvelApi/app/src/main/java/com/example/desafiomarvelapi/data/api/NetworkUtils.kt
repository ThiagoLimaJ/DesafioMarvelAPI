package com.example.desafiomarvelapi.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
const val PUBLIC_API_KEY =  "6eb7e8896ec5850c52515a8a23ee97f0"
const val PRIVATE_API_KEY = "0dd0c16fedb8a02985977eafca66b49f5e6a526f"

class NetworkUtils {

    companion object {
        private const val BASE_URL = "https://gateway.marvel.com:443/v1/public/"

        fun getRetrofitInstance(): Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}