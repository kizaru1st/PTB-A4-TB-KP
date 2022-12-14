package com.example.latihanandroid

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.TaskStackBuilder
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import kotlinx.android.synthetic.main.activity_edit_profile.*
import kotlinx.android.synthetic.main.activity_sign_in.*

class EditProfileActivity : AppCompatActivity() {
    val CHANNEL_ID_EditProfile = "channelID_EditProfile"
    val CHANNEL_NAME_EditProfile = "channelName_EditProfile"
    val NOTIFICATION_ID_EditProfile = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createNotificationChannel()
        }
        val intent = Intent(this, ProfileActivity::class.java)
        val pendingIntent = TaskStackBuilder.create(this).run {
            addNextIntentWithParentStack(intent)
            getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT)
        }
        val notification = NotificationCompat.Builder(this, CHANNEL_ID_EditProfile)
            .setContentTitle("PTB A4")
            .setContentText("Berhasil Edit Profile!")
            .setSmallIcon(R.drawable.ic_star)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentIntent(pendingIntent)
            .build()
        val notificationManager = NotificationManagerCompat.from(this)

        btnReset.setOnClickListener {
            notificationManager.notify(NOTIFICATION_ID_EditProfile, notification)
            var intent = Intent(this@EditProfileActivity, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun createNotificationChannel() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(CHANNEL_ID_EditProfile, CHANNEL_NAME_EditProfile, NotificationManager.IMPORTANCE_DEFAULT).apply {
                lightColor = Color.GREEN
                enableLights(true)
            }
            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannel(channel)
        }
    }
}