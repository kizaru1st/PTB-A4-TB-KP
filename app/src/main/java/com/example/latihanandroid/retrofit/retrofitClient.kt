package com.example.latihanandroid.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object retrofitClient {
    private const val base_URL = "http://ptb-api.husnilkamil.my.id/"
    fun create() : Api{
        val retrofit = Retrofit.Builder()
            . baseUrl(base_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(Api::class.java)
    }
}