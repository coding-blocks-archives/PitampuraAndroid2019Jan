package com.codingblocks.broadcasts

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val powerBroadcast = GenericReceiver()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*
            if android version is less than Oreo, then register the receiver in the manifest
            else, start a foreground service and register the receiver there
         */

        val intentFilter = IntentFilter().apply {
            addAction(Intent.ACTION_POWER_CONNECTED)
            addAction(Intent.ACTION_POWER_DISCONNECTED)
            addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED)
        }

        registerReceiver(powerBroadcast, intentFilter)


        val intent = Intent(this, CustomBroadcastReceiver::class.java)
            .apply {
                putExtra("KEY", "https://www.google.com")
            }

        sendBroadcast(intent)

    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(powerBroadcast)
    }
}
