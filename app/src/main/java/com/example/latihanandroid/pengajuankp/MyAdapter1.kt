package com.example.latihanandroid.pengajuankp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.latihanandroid.datamodels.InternshipItem

class MyAdapter1(private var data: ArrayList<InternshipItem>): RecyclerView.Adapter<ViewHolder1>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder1 {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder1 (inflater, parent)
    }

    fun setListKpMahasiswa(list: ArrayList<InternshipItem>){
        data = list
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder1, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }
}