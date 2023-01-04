package com.example.latihanandroid.retrofit.pengajuankp1;

import com.google.gson.annotations.SerializedName;

public class PengajuankpResponce{

    @SerializedName("proposal")
    private Proposal proposal;

    @SerializedName("message")
    private String message;

    @SerializedName("status")
    private String status;

    public Proposal getProposal(){
        return proposal;
    }

    public String getMessage(){
        return message;
    }

    public String getStatus(){
        return status;
    }
}