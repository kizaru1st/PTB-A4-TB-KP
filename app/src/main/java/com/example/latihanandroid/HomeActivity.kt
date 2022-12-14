package com.example.latihanandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.Data
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.latihanandroid.Home.AdapterListKP
import com.example.latihanandroid.Home.DataListKP
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_sign_in.*

class HomeActivity : AppCompatActivity() {

    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<DataListKP>
    lateinit var instansi: Array<String>
    lateinit var status: Array<String>
    lateinit var alasan: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        cvProfile.setOnClickListener {
            var intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }

        btnDetailKP.setOnClickListener {
            var intent = Intent(this, PengajuanKPActivity::class.java)
            startActivity(intent)
        }

        btnPengajuanKP.setOnClickListener {
            var intent = Intent(this, DetailKPActivity::class.java)
            startActivity(intent)
        }


        instansi = arrayOf(
            "Kominfo Padang",
            "Multipolar",
            "PT Semen Padang",
            "Kominfo Sumbar",
            "Disukcapil Padang",
            "Kominfo Padang",
            "Multipolar",
            "PT Semen Padang",
            "Kominfo Sumbar",
            "Disukcapil Padang",
            "Kominfo Sumbar",
            "Disukcapil Padang"
        )

        status = arrayOf(
            "Diterima",
            "Ditolak",
            "Ditolak",
            "Ditolak",
            "Ditolak",
            "Diterima",
            "Ditolak",
            "Ditolak",
            "Ditolak",
            "Ditolak",
            "Ditolak",
            "Ditolak"
        )

        alasan = arrayOf(
            "Alasan 1",
            "Alasan 2",
            "Alasan 3",
            "Alasan 4",
            "Alasan 5",
            "Alasan 6",
            "Alasan 7",
            "Alasan 8",
            "Alasan 9",
            "Alasan 10",
            "Alasan 11",
            "Alasan 12",
        )

        newRecyclerView = findViewById(R.id.rvList)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)

//      Passing data to adapter
        newArrayList = arrayListOf<DataListKP>()
        getUserdata()
    }

    private fun getUserdata() {
        for(i in instansi.indices) {
            val datalist = DataListKP(instansi[i], status[i], alasan[i])
            newArrayList.add(datalist)
        }
        newRecyclerView.adapter = AdapterListKP(newArrayList)
    }
}