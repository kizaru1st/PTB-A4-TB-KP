package com.example.latihanandroid

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.latihanandroid.Adapter.ReferensiAdapter
import com.example.latihanandroid.datamodels.ReferensiResponse
import com.example.latihanandroid.retrofit.retrofitClient
import retrofit2.Call
import com.example.latihanandroid.databinding.ActivityReferensiTempatKpBinding
import retrofit2.Callback
import retrofit2.Response
import java.util.ArrayList

class referensi_tempat_kp : AppCompatActivity() {

    private lateinit var binding: ActivityReferensiTempatKpBinding
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReferensiTempatKpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recyclerView = findViewById(R.id.recycler_view3)
        recyclerView.layoutManager = LinearLayoutManager(this)

        getDataFromAPI()
    }

    private fun getDataFromAPI() {
        val sharedPreferences = applicationContext?.getSharedPreferences("sharedPref", Context.MODE_PRIVATE) ?: return
        val token = sharedPreferences.getString("TOKEN", "")
        if (token != null) {
            Log.d("TOKEN LH: ", token)
        }

        val list = ArrayList<ReferensiResponse.Companies>()
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(applicationContext)

        val retrofitClient = retrofitClient.create()
        val callData = retrofitClient.referensiList("Bearer $token")
        callData.enqueue(object : Callback<ReferensiResponse> {
            override fun onResponse(
                call: Call<ReferensiResponse>,
                response: Response<ReferensiResponse>
            ) {
                Toast.makeText(applicationContext, "Berhasil memanggil", Toast.LENGTH_SHORT).show()
//                Log.d("Hasilnya nih", response.body().toString())
                val data = response.body()
                data?.companies.let {
                    if (it != null) {
                        list.addAll(it)
                    }
                }
                val adapterGet = ReferensiAdapter(list)
                recyclerView.adapter = adapterGet
            }

            override fun onFailure(call: Call<ReferensiResponse>, t: Throwable) {
                Toast.makeText(applicationContext, "Yah gagal", Toast.LENGTH_SHORT).show()
                Log.d("throwable", t.toString())
            }

        })
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}