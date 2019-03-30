package com.codingblocks.services

import android.app.IntentService
import android.content.Intent
import android.util.Log

//Runs on a different thread by default
class DownloadIntentService : IntentService("DownloadService") {

    val TAG = javaClass.simpleName

    override fun onCreate() {
        super.onCreate()
        Log.e(TAG, "onCreate")
    }

    override fun onHandleIntent(intent: Intent?) {
        Log.e(TAG,"Network call started")

        Thread.sleep(2000)
        //Making a network call here

        Log.e(TAG,"Network call finished")
        //make the network request
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e(TAG, "onDestroy")
    }

}