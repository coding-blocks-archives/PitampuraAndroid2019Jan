package com.codingblocks.alarms

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.SystemClock
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    /*
        Next Steps
        1. Implement Database in your app and make the network
        request only when the db is empty or outdated
        2. Inside the MainActivity, schedule an alarm that :
            a. Gets fired every day at approximately 10pm and queries the API to
            fetch and store updated news in the db.
            b. (Optional) Use a service that fetches and stores the news in background.
            c. (Optional) The Service displays a notification while it's downloading and saving the news entries
     */

    private val alarmManager by lazy {
        getSystemService(Context.ALARM_SERVICE) as AlarmManager
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {

            //Set the alarm here

            val alarmIntent = PendingIntent.getActivity(this,
                    12345,
                    Intent(this, MainActivity::class.java),
                    PendingIntent.FLAG_UPDATE_CURRENT)

            val triggerTime = editText.text.toString().toLong() * 1000

            alarmManager.setRepeating(
                    AlarmManager.ELAPSED_REALTIME,
                    SystemClock.elapsedRealtime() + triggerTime,
                    15 * 60 * 1000,
                    alarmIntent
            )
        }

    }

//    fun convertInputToMillis(hh: Int, mm: Int, date: Int, month: Int, year: Int) {
//
//        val calendar = Calendar.getInstance().apply {
//            timeInMillis = System.currentTimeMillis()
//
//        }
//
//        calendar.timeInMillis = System.currentTimeMillis()
//
//        calendar.set(Calendar.MONTH,12)
//        calendar.set(Calendar.DAY_OF_MONTH,25)
//        calendar.set(Calendar.HOUR_OF_DAY,16)
//        calendar.set(Calendar.MINUTE, 30)
//        calendar.set(Calendar.SECOND,30)
//
////        calendar.set(Calendar.WEEK_OF_MONTH,3)
////        calendar.set(Calendar.DAY_OF_WEEK,4)
////        calendar.set(Calendar.HOUR_OF_DAY,9)
//
//        val longTime = calendar.timeInMillis
//
//    }

}
