package com.example.latihanandroid.datamodels

import com.google.gson.annotations.SerializedName

data class Proposal(

    @field:SerializedName("end_at")
    val endAt: String? = null,

    @field:SerializedName("updated_at")
    val updatedAt: String? = null,

    @field:SerializedName("purpose")
    val purpose: String? = null,

    @field:SerializedName("agency_id")
    val agencyId: String? = null,

    @field:SerializedName("created_at")
    val createdAt: String? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("start_at")
    val startAt: String? = null,

    @field:SerializedName("title")
    val title: String? = null
)