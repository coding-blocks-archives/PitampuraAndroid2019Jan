package com.codingblocks.foregroundservice

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.coroutines.Continuation

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val serviceIntent = Intent(this, ForegroundService::class.java)

        val nm = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                "first",
                "Default channel",
                NotificationManager.IMPORTANCE_DEFAULT
            ).apply {
                description = "This is the default channel for all the notifications"
            }

            nm.createNotificationChannel(channel)
        }

        btnStartService.setOnClickListener {

            //Use the compat class's startForegroundService method
            //for consistent behaviour across different API verions
            ContextCompat.startForegroundService(this, serviceIntent)
        }

    }
}
