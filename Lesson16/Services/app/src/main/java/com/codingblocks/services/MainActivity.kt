package com.codingblocks.services

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startService = Intent(this, DownloadIntentService::class.java).apply {
            putExtra("COUNT", 5)
            putExtra("KEY", "HELLO")
        }

        btnStartServicew.setOnClickListener {
            startService(startService)
        }

    }
}
