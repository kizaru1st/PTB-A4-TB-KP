package com.example.latihanandroid

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.belajar_retrofit.datamodels.Config
import com.example.latihanandroid.databinding.ActivityTambahLogBinding
import com.example.latihanandroid.datamodels.TambahLogbookResponse
import com.example.latihanandroid.retrofit.Api
import com.google.android.datatransport.runtime.scheduling.SchedulingConfigModule_ConfigFactory.config
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig
import kotlinx.android.synthetic.main.activity_tambah_log.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TambahLogActivity : AppCompatActivity() {
    lateinit var binding: ActivityTambahLogBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTambahLogBinding.inflate(layoutInflater)
        setContentView(binding.root)
        button3.setOnClickListener {
            Save()
        }
    }

    fun Save() {
        val sharedToken = getSharedPreferences("sharedPref", Context.MODE_PRIVATE)?: return
        val token = sharedToken.getString("TOKEN",null)
        val kegiatan = binding.InsertLogBook.text.toString()
        val client: Api = Config().getService()
        val call: Call<TambahLogbookResponse> = client.tambah_logbook(token = "Bearer $token", 5, kegiatan)
        call.enqueue(object: Callback<TambahLogbookResponse> {
            override fun onFailure(call: Call<TambahLogbookResponse>, t: Throwable) {
                Log.d("tambah-debug",t.localizedMessage)
            }
            override fun onResponse(
                call: Call<TambahLogbookResponse>,
                response: Response<TambahLogbookResponse>
            ) {
                val respon: TambahLogbookResponse? = response.body()
                if (respon != null && respon.status == "success" ) {
                    Toast.makeText(this@TambahLogActivity, "Berhasil Mengupdate Respon", Toast.LENGTH_SHORT).show()
                    intent = Intent(applicationContext, LogActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                    startActivity(intent)
                    finish()
                }
            }
        })
    }


}
