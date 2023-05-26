package com.example.islamii

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build



class MyApplication: Application (){
 companion object{
     val RADIO_PLAAYER_NOTIFICATION_CHANNEL="radio_channel"

 }

    override fun onCreate() {
        super.onCreate()
        createNotificationChannel()

    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            val name = getString(R.string.app_name)
            val desc = getString(R.string.Radio)
            val importance = NotificationManager.IMPORTANCE_LOW
            val channel = NotificationChannel(RADIO_PLAAYER_NOTIFICATION_CHANNEL,name,importance).apply {
                description = desc
            }

            //register the channel with the system

            val notificationManager:NotificationManager = getSystemService(Context.NOTIFICATION_SERVICE )as NotificationManager
              notificationManager.createNotificationChannel(channel)

        }
    }

}