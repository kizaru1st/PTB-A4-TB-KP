package com.example.latihanandroid.retrofit

import retrofit2.http.POST
import com.example.latihanandroid.datamodels.LoginResponse
import com.example.latihanandroid.datamodels.LogoutResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Header

interface Login {
    @FormUrlEncoded
    @POST("login")
    fun login(
        @Field("username") username: String,
        @Field("password") password: String
    ): Call<LoginResponse?>?
    @POST("logout")
    fun logout(@Header("Authorization") token: String) : Call<LogoutResponse>
}