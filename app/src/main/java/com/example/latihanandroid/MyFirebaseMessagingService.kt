package com.example.latihanandroid

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService : FirebaseMessagingService() {
    private val channel_id = "contoh"
    private val notifId = 1

    override fun onNewToken(token: String) {
        super.onNewToken(token)
    }

    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)
        val a = message.notification?.title.toString()
        val b = message.notification?.body.toString()

        createNotificationChannel()
        showNotification(a, b)
    }

    fun showNotification (title: String, message: String){
        val builder = NotificationCompat.Builder(this, channel_id)
            .setContentTitle(title)
            .setContentText(message)
            .setSmallIcon(R.drawable.ic_star)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
        with(NotificationManagerCompat.from(this)){
            notify(1, builder.build())
        }
    }

    private fun createNotificationChannel(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val name = "Notification title"
            val descriptionText = "Notification description"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(channel_id, name, importance).apply {
                description = descriptionText
            }
            val notificationManager : NotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

}

