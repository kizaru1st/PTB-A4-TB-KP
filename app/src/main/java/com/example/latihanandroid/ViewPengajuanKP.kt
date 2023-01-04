package com.example.latihanandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.latihanandroid.pengajuankp.ListAjuan
import com.example.latihanandroid.pengajuankp.MyAdapter1

class ViewPengajuanKP : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var adapter : MyAdapter1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pengajuan_kp)
        supportActionBar?.hide()

        init()
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }

    private fun init () {
        recyclerView = findViewById(R.id.rv_view)

        var data = ArrayList <ListAjuan>()
        data.add(ListAjuan("Hanif Izza Pratama","20 November 2022", "LLDIKTI"))
        data.add(ListAjuan("Nada Safarina","25 November 2022", "PT Mutiara"))
        data.add(ListAjuan("Nathaniarahayu","26 November 2022", "PT Semen Padang"))
        data.add(ListAjuan("Annisa Faras","26 November 2022", "PLN Sawahan"))
        data.add(ListAjuan("Putri Wulan Dari","26 November 2022", "RS Semen Padang"))

        adapter = MyAdapter1(data)
    }

}