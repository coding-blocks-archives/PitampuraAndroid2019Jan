package com.codingblocks.broadcasts

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class CustomBroadcastReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {

//        val result = goAsync() //This line tells the broadcast receiver that there's some async task happening in onReceive
//
//        //If you don't write goAsync(), the receiver is killed as soon as the flow returns from onReceive()
//
//        thread {
//            //Network call that takes 1 sec
//
//            result.finish()
//        }

        //This runs on the UI thread
        //get the URL and probably make a network call?

        //Let's say that you start a new thread here,
        //the system will still kill this receiver after 5-6 seconds

        //In the stone age days, people used to start services from their receivers
        //to ensure that a work was completed successfully
    }

}

//FireBase -> Login, Cloud Data store, Notifications, File Upload, Ads, MlKit
//ViewModels/LiveData -> No feature
//Permissions -> Runtime permissions
//Sensors/Camera -> Step Counter, Accelerometer, Gravity, Proximity, Gyroscope
//Location -> How to get the user's location, speed, finding the address from location
//Maps -> Plotting the user's location, finding nearby points of interest, etc.

//Play Store Publishing -> How to publish apps to google play (Demo day)