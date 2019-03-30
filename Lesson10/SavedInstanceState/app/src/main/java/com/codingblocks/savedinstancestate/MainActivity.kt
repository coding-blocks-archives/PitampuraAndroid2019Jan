package com.codingblocks.savedinstancestate

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView.text = count.toString()

        button.setOnClickListener {
            count++
            textView.text = count.toString()
        }
    }

    //Called when the user wasn't expecting to kill the app but the app as killed regardless
    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putInt("COUNT", count)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        count = savedInstanceState?.getInt("COUNT") ?: 0
        textView.text = count.toString()
    }

}
