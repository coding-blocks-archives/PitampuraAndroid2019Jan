package com.codingblocks.services

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import kotlin.concurrent.thread

//Runs on the main thread
//Does not kill itself once the work is done
//Can cause memory leaks
class DownloadService : Service() {

    val TAG = javaClass.simpleName

    override fun onCreate() {
        super.onCreate()
        Log.e(TAG, "onCreate")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.e(TAG, "onStartCommand")

        intent?.let {
            val count = it.getIntExtra("COUNT", 0)
        }

        thread {
            Log.e(TAG,"Network call started")

            Thread.sleep(2000)
            //Making a network call here

            Log.e(TAG,"Network call finished")


            //Ensure that you call stopSelf() once the work is done
            //so that the service is killed by the OS to prevent memory leaks
            stopSelf()

        }

        //START_STICKY means that the service will be restarted if it was killed by the OS
        //But post Android 26, regardless of what you return, the service won't be started
        //again once destroyed

        return START_STICKY_COMPATIBILITY
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e(TAG, "onDestroy")
    }

    override fun onLowMemory() {
        super.onLowMemory()
        Log.e(TAG, "onLowMemory")
    }

    override fun onBind(intent: Intent?): IBinder? {
        Log.e(TAG, "onBind")
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}