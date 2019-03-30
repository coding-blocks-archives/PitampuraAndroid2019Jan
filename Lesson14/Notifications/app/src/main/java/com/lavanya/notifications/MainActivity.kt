package com.lavanya.notifications

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.NotificationCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nm = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            nm.createNotificationChannel(
                NotificationChannel(
                    "first",
                    "default",
                    NotificationManager.IMPORTANCE_DEFAULT
                )
            )

            nm.createNotificationChannel(
                NotificationChannel(
                    "second",
                    "default",
                    NotificationManager.IMPORTANCE_DEFAULT
                )
            )


        }

        btnSimple.setOnClickListener {

            val simpleNotification = NotificationCompat.Builder(baseContext, "first")
                .setSmallIcon(R.drawable.ic_android_black)
                .setContentTitle("Simple Notification")
                .setContentText("Captain Marvel")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .build()

            nm.notify(System.currentTimeMillis().toInt(), simpleNotification)


        }

        btnIntent.setOnClickListener {

            val i = Intent()
            i.action = Intent.ACTION_VIEW
            i.data = Uri.parse("https://www.google.com")

            val pi = PendingIntent.getActivity(baseContext, 1234, i, PendingIntent.FLAG_UPDATE_CURRENT)

            val clickableNotification = NotificationCompat.Builder(baseContext, "first")
                .setSmallIcon(R.drawable.ic_android_black)
                .setContentTitle("Simple Notification")
                .setContentText("Captain Marvel")
                .setContentIntent(pi)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .build()

            nm.notify(2, clickableNotification)
        }

        btnLongText.setOnClickListener {

            val bigTextStyle = NotificationCompat.Builder(baseContext, "first")
                .setSmallIcon(R.drawable.ic_android_black)
                .setContentTitle("Simple Notification")
                .setContentText("Captain Marvel")
                .setStyle(
                    NotificationCompat.BigTextStyle().bigText(
                        "Hello from longText Hello from longText " +
                                "Hello from longText Hello from longText Hello from longText Hello from longText " +
                                "Hello from longText Hello from longText Hello from longText Hello from longText " +
                                "Hello from longText Hello from longText Hello from longText hello from longText " +
                                "hello from longText  "
                    )
                )
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .build()

            nm.notify(3, bigTextStyle)

        }

        btnAction.setOnClickListener {

            val i = Intent()
            i.action = Intent.ACTION_VIEW
            i.data = Uri.parse("https://www.google.com")

            val pi = PendingIntent.getActivity(baseContext, 12345, i, PendingIntent.FLAG_UPDATE_CURRENT)

            val actionedNotification = NotificationCompat.Builder(baseContext, "first")
                .setSmallIcon(R.drawable.ic_android_black)
                .setContentTitle("Simple Notification")
                .setContentText("Captain Marvel")
                .addAction(R.mipmap.ic_launcher, "Click", pi)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .build()

            nm.notify(4, actionedNotification)
        }

        btnExpanding.setOnClickListener {

            val icon = BitmapFactory.decodeResource(baseContext.getResources(), R.drawable.ic_attachment_black_24dp);

            val ExpandingNotification = NotificationCompat.Builder(baseContext, "first")
                .setSmallIcon(R.drawable.ic_android_black)
                .setContentTitle("Simple Notification")
                .setContentText("Captain Marvel")
                .setLargeIcon(icon)
                .setStyle(
                    NotificationCompat.BigPictureStyle().bigPicture(icon)

                )
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .build()

            nm.notify(5, ExpandingNotification)

        }


    }
}
