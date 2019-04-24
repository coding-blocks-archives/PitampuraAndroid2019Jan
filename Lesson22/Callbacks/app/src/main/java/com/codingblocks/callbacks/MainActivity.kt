package com.codingblocks.callbacks

import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.telecom.Call
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity(), CallbackInterface {

    override fun onResult(result: String) {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

//        mainModel.fetchUsersFromApi(this)

        mainModel.fetchUsersFromApiCb { s, i ->
            Log.e("TAG", s)
        }

        startCounting(10000000000L) {
            tvMain.text = it
        }

    }

    private fun startCounting(limit: Long, xyz: (String) -> Unit) {
        thread {
            for (i in 0..limit) {
            }
            xyz("Counting Done")
        }
    }

}
