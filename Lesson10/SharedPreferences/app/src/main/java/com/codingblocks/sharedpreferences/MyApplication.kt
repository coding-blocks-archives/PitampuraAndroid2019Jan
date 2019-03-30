package com.codingblocks.sharedpreferences

import android.app.Application
import android.content.Context

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        val sharedPreferences = getSharedPreferences("mySharedPreferences", Context.MODE_PRIVATE)
        val isLoggedIn = sharedPreferences.contains("IS_LOGGED_IN")
        if (isLoggedIn) {
            //Start intent for the home screen
        } else {
            //Start intent for login screen
            //Set the flag IS_LOGGED_IN to `true` once the user has successfully logged in
        }

    }

}