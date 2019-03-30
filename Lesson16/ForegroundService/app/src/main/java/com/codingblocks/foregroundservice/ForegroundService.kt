package com.codingblocks.foregroundservice

import android.app.Notification
import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.support.v4.app.NotificationCompat

class ForegroundService : Service() {

    override fun onCreate() {
        super.onCreate()

        val notification: Notification = NotificationCompat.Builder(this, "first")
            .setContentTitle(getText(R.string.notification_title))
            .setContentText(getText(R.string.notification_message))
            .setSmallIcon(R.drawable.ic_run)
            .build()

        startForeground(1234, notification)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        //Remember to kill the foreground service once the task is done
        stopForeground(true)
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onBind(intent: Intent?): IBinder? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}