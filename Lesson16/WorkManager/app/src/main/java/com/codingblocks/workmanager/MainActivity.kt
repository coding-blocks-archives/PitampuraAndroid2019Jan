package com.codingblocks.workmanager

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import androidx.work.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val constraints = Constraints.Builder()
            .setRequiresCharging(true)  //Device should be charging for this task to run
//            .setRequiresDeviceIdle(true)
            .setRequiredNetworkType(NetworkType.CONNECTED) //Device should be connected to a network
//            .setRequiresStorageNotLow(true)
            .build()

        //Pass some data to your worker
        val data = Data.Builder()
            .putString("URL", "https://www.google.com")
            .build()

        //Defining oneTime request with WorkManager
        val downloadWorker = OneTimeWorkRequestBuilder<DownloadAndStoreTask>()
            .setInitialDelay(10, TimeUnit.HOURS)
            .setConstraints(constraints)
            .setInputData(data)
            .build()

        WorkManager.getInstance().enqueue(downloadWorker)

        //Execute a periodic work Request
        val periodicWorker = PeriodicWorkRequestBuilder<DownloadAndStoreTask>(
            1,
            TimeUnit.DAYS
        )
            .setConstraints(constraints)
            .build()

        WorkManager.getInstance().enqueue(periodicWorker)

        //Periodic work request with initial delay : https://stackoverflow.com/a/51947148
    }
}
