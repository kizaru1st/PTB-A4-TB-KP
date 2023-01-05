package com.example.latihanandroid

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.example.belajar_retrofit.datamodels.Config
import com.example.belajar_retrofit.datamodels.DetailLogBookResponse
import com.example.latihanandroid.databinding.ActivityListLogbookBinding
import com.example.latihanandroid.retrofit.Api
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailLogBookActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_log_book)
        val sharedToken = getSharedPreferences("sharedPref", Context.MODE_PRIVATE)?: return
        val logbookpref = getSharedPreferences("logbookpref", Context.MODE_PRIVATE)?:return
        val token = sharedToken.getString("TOKEN","")
        val id = sharedToken.getInt("id",5)
        val idl = logbookpref.getString("id_logbook",null)
        Log.d("Detail-logbook-debug","respon "+idl.toString())

        val client: Api = Config().getService()
        val call: Call<DetailLogBookResponse> = client.detailLogbook(token = "Bearer "+token,id,idl)
        Log.d("Detail-logbook-debug","respon "+token.toString())
        call.enqueue(object : Callback<DetailLogBookResponse> {
            override fun onResponse(
                call: Call<DetailLogBookResponse>,
                response: Response<DetailLogBookResponse>
            ) {
                val respon = response.body()
                if(respon!=null){
                    val judulKegiatan : TextView = findViewById(R.id.tvKegiatanList)
                    val kegiatan = respon.logbook?.activities
                    judulKegiatan.text = kegiatan
                }
            }
            override fun onFailure(call: Call<DetailLogBookResponse>, t: Throwable) {
                Log.d("detail-debug", t.localizedMessage)
            }

        })
    }
}