package com.codingblocks.workmanager

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

class DownloadAndStoreTask(context: Context, workerParams: WorkerParameters) :
    Worker(context, workerParams) {

    override fun doWork(): Result {

        //Getting the input data that was passed from the activity
        inputData.getString("URL")

        //Make a Network call here

        //I can go ahead and save the response into a db

        return Result.success()
    }

}