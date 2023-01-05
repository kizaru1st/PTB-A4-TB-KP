package com.example.latihanandroid

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.belajar_retrofit.datamodels.LogbooksItem
import com.example.latihanandroid.databinding.ItemListLogbookBinding

class LogbookAdapter ()
    :RecyclerView.Adapter<LogbookAdapter.LogBookViewHolder>(){

    private lateinit var logbokLister : onClickListener

    interface onClickListener{
        fun onItemClick(position: Int)
    }
    fun setOnClickListener(listener: onClickListener){
        logbokLister = listener
    }
    var listLogbook : List<LogbooksItem> = ArrayList()

    fun setlistLogbook(listLogbook:List<LogbooksItem>){
        this.listLogbook = listLogbook
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LogBookViewHolder {
        return  LogBookViewHolder(ItemListLogbookBinding.inflate(LayoutInflater.from(parent.context)
            , parent, false),logbokLister)
    }

    override fun onBindViewHolder(holder: LogBookViewHolder, position: Int) {
        val item : LogbooksItem = listLogbook.get(position)
        holder.itemBinding.tvHariKe.text = item.activities
        holder.itemBinding.tvTanggal.text = item.date
        holder.itemBinding.tvKegiatan.text = item.note
    }
    override fun getItemCount(): Int {
        return listLogbook.size
    }
    inner class LogBookViewHolder(val itemBinding:ItemListLogbookBinding,listener: onClickListener):
        RecyclerView.ViewHolder(itemBinding.root) {
        init {
            itemView.setOnClickListener{
                listener.onItemClick(bindingAdapterPosition)
            }
        }
    }
}