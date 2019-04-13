package com.codingblocks.firebase

import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyMessagingService : FirebaseMessagingService() {

    override fun onMessageReceived(p0: RemoteMessage?) {
        //Do something with your remote data here
        val url = p0?.data?.get("IMG_URL")

    }
}