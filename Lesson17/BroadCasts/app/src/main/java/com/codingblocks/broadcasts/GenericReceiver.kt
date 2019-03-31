package com.codingblocks.broadcasts

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

class GenericReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {

        when (intent?.action) {

            Intent.ACTION_AIRPLANE_MODE_CHANGED -> {
                Toast.makeText(context, "Airplane mode changed", Toast.LENGTH_SHORT).show()
            }

            Intent.ACTION_NEW_OUTGOING_CALL -> {
                Toast.makeText(context, "Broadcast started", Toast.LENGTH_SHORT).show()
                Log.e("TAG", "Outgoing call, Number : ${intent.getStringExtra(Intent.EXTRA_PHONE_NUMBER)}")
            }

            else -> {
                Toast.makeText(context, "Unregistered Action", Toast.LENGTH_SHORT).show()
            }

        }

    }

}