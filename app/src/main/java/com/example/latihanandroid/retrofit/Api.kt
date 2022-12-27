package com.example.latihanandroid.retrofit

import com.example.latihanandroid.datamodels.GetProfileResponse
import com.example.latihanandroid.datamodels.LoginResponse
import com.example.latihanandroid.datamodels.LogoutResponse
import com.example.latihanandroid.datamodels.UpdateProfileResponse
import retrofit2.Call
import retrofit2.http.*

interface Api {
    @FormUrlEncoded
    @POST("login")
    fun login(
        @Field("username") username: String,
        @Field("password") password: String
    ): Call<LoginResponse?>?

    @POST("logout")
    fun logout(@Header("Authorization") token: String) : Call<LogoutResponse>

    @GET("/api/me")
    fun profile(@Header("Authorization") token:String):Call<GetProfileResponse>

    @FormUrlEncoded
    @POST("/api/me/update")
    fun updateProfile(
        @Header("Authorization") token:String,
        @Field("name") name:String,
        @Field("email") email:String
    ):Call<UpdateProfileResponse>
}