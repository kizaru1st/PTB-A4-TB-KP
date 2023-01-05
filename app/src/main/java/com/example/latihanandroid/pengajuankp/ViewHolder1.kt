package com.example.latihanandroid.pengajuankp

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.latihanandroid.R
import com.example.latihanandroid.datamodels.InternshipItem

class ViewHolder1(inflater: LayoutInflater, parent: ViewGroup): RecyclerView.ViewHolder(inflater.inflate(
    R.layout.list_pengajuankp, parent, false)){

    private var Tittle : TextView? = null
    private var TittleSub : TextView? = null


    init {
        Tittle = itemView.findViewById(R.id.tittle)
        TittleSub = itemView.findViewById(R.id.tittle_sub)


    }

    fun bind (data:InternshipItem){
        Tittle?.text=data.agency
        TittleSub?.text=data.title

    }

}