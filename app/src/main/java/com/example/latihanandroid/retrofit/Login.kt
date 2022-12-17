package com.example.latihanandroid.retrofit

import retrofit2.http.POST
import com.example.latihanandroid.datamodels.LoginResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded

interface Login {
    @FormUrlEncoded
    @POST("login")
    fun login(
        @Field("username") username: String,
        @Field("password") password: String
    ): Call<LoginResponse?>?
}