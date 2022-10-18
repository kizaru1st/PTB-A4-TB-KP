package com.example.latihanandroid

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.latihanandroid.Home.AdapterLogbook
import com.example.latihanandroid.logbook.DataLogbook
import com.example.latihanandroid.logbook.DetailrvLogbook

class LogBookActivity : AppCompatActivity() {

    private lateinit var rv : RecyclerView
    private lateinit var kegList : ArrayList<DataLogbook>
    private lateinit var adapter: AdapterLogbook

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_logbook)

        rv = findViewById(R.id.rvListLogbook1)
        rv.layoutManager = LinearLayoutManager(this)
        rv.setHasFixedSize(true)

        kegList = ArrayList()

        kegList.add(DataLogbook("Hari Pertama", "30 September 2022", "Kegiatan Kerja Praktik"))
        kegList.add(DataLogbook("Hari Kedua", "1 Oktober 2022", "Kegiatan Kerja Praktik"))
        kegList.add(DataLogbook("Hari Ketiga", "2 Oktober 2022", "Kegiatan Kerja Praktik"))
        kegList.add(DataLogbook("Hari Keempat", "3 Oktober 2022", "Kegiatan Kerja Praktik"))
        kegList.add(DataLogbook("Hari Kelima", "3 Oktober 2022", "Kegiatan Kerja Praktik"))
        kegList.add(DataLogbook("Hari Keenam", "3 Oktober 2022", "Kegiatan Kerja Praktik"))
        kegList.add(DataLogbook("Hari Ketujuh", "3 Oktober 2022", "Kegiatan Kerja Praktik"))
        kegList.add(DataLogbook("Hari Kedelapan", "3 Oktober 2022", "Kegiatan Kerja Praktik"))

        adapter = AdapterLogbook(kegList)
        rv.adapter = adapter

        adapter.setOnItemClickListener(object : AdapterLogbook.onItemClickListener{
            override fun onItemClick(position: Int) {
                val intent = Intent(this@LogBookActivity, DetailrvLogbook::class.java)
                intent.putExtra("hari", kegList[position].hari)
                intent.putExtra("tanggal", kegList[position].tanggal)
                intent.putExtra("kegiatan", kegList[position].kegiatan)
                startActivity(intent)
            }

        })
    }
}