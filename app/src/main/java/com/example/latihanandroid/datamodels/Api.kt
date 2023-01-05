package com.example.latihanandroid.retrofit

import com.example.belajar_retrofit.datamodels.DetailLogBookResponse
import com.example.belajar_retrofit.datamodels.LogbookResponse
import com.example.latihanandroid.datamodels.*
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

    @FormUrlEncoded
    @POST("/api/password")
    fun updatePassword(
        @Header("Authorization")token: String,
        @Field("old_password") old_password:String,
        @Field("new_password") new_password:String,
        @Field("confirm_password") confirm_password:String
    ):Call<UpdatePasswordResponse>

//    UAS
    @GET("/api/my-internship/{id}/logbook")
    fun listlogbook(@Header("Authorization") token: String, @Path("id") id:Int
    ):Call<LogbookResponse>

    @POST("/api/my-internship/{id}/finish-statement")
    fun laporSelesaiKp(
        @Header("Authorization") token: String,
        @Path("id") id:Int,
        @Field("end_date") end_date:String
    ):Call<LaporKpSelesaiResponse>

    @GET("/api/my-internship/{id}/logbook/{id_logbook}")
    fun detailLogbook(@Header("Authorization") token: String,
                          @Path("id") id: Int,
                          @Path("id_logbook") id_logbook: String?
    ):Call<DetailLogBookResponse>

    @FormUrlEncoded
    @POST("/api/my-internship/{id}/logbook")
    fun tambah_logbook(
        @Header("Authorization") token: String,
        @Path("id") id : Int,
        @Field("activities") activities:String
    ):Call<TambahLogbookResponse>
}