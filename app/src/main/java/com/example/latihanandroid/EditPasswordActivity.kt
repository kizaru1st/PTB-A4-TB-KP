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
import kotlinx.android.synthetic.main.activity_edit_password.*

class EditPasswordActivity : AppCompatActivity() {
    val CHANNEL_ID_EditPassword = "channelID_EditPassword"
    val CHANNEL_NAME_EditPassword = "channelName_EditPassword"
    val NOTIFICATION_ID_EditPassword = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_password)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createNotificationChannel()
        }
        val intent = Intent(this, ProfileActivity::class.java)
        val pendingIntent = TaskStackBuilder.create(this).run {
            addNextIntentWithParentStack(intent)
            getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT)
        }
        val notification = NotificationCompat.Builder(this, CHANNEL_ID_EditPassword)
            .setContentTitle("PTB A4")
            .setContentText("Berhasil Update Password!")
            .setSmallIcon(R.drawable.ic_star)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentIntent(pendingIntent)
            .build()
        val notificationManager = NotificationManagerCompat.from(this)
        btnEditPassword.setOnClickListener {
            notificationManager.notify(NOTIFICATION_ID_EditPassword, notification)
            var intent = Intent(this@EditPasswordActivity, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun createNotificationChannel() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(CHANNEL_ID_EditPassword, CHANNEL_NAME_EditPassword, NotificationManager.IMPORTANCE_DEFAULT).apply {
                lightColor = Color.GREEN
                enableLights(true)
            }
            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannel(channel)
        }
    }
}