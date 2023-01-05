package com.example.latihanandroid.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.latihanandroid.R
import com.example.latihanandroid.datamodels.ReferensiResponse

class ReferensiAdapter(private val referensilist: ArrayList<ReferensiResponse.Companies>) : RecyclerView.Adapter<ReferensiAdapter.referensiViewHolder>() {
    private lateinit var myListener : onItemClickListener

    interface onItemClickListener{
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener){
        myListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): referensiViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_referensi_kp, parent, false)
        return referensiViewHolder(view, myListener)
    }

    override fun onBindViewHolder(holder: referensiViewHolder, position: Int) {
        val currentPosition = referensilist[position]
        holder.namaInstansi.text = currentPosition.name
        holder.alamat.text = currentPosition.address
    }

    override fun getItemCount(): Int {
        return referensilist.size
    }

    class referensiViewHolder(itemView: View, listener: onItemClickListener) : RecyclerView.ViewHolder(itemView){
        val namaInstansi : TextView = itemView.findViewById(R.id.namaInstansi)
        val alamat: TextView = itemView.findViewById(R.id.alamatInstansi)
    }
}