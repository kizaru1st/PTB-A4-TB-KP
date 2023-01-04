package com.example.latihanandroid.retrofit.pengajuankp1;

import com.google.gson.annotations.SerializedName;

public class Proposal{

    @SerializedName("end_at")
    private String endAt;

    @SerializedName("updated_at")
    private String updatedAt;

    @SerializedName("purpose")
    private String purpose;

    @SerializedName("agency_id")
    private String agencyId;

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("id")
    private int id;

    @SerializedName("start_at")
    private String startAt;

    @SerializedName("title")
    private String title;

    public String getEndAt(){
        return endAt;
    }

    public String getUpdatedAt(){
        return updatedAt;
    }

    public String getPurpose(){
        return purpose;
    }

    public String getAgencyId(){
        return agencyId;
    }

    public String getCreatedAt(){
        return createdAt;
    }

    public int getId(){
        return id;
    }

    public String getStartAt(){
        return startAt;
    }

    public String getTitle(){
        return title;
    }
}