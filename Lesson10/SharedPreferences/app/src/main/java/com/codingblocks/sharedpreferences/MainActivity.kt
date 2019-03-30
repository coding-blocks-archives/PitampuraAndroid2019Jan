package com.codingblocks.sharedpreferences

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sharedPreferences = getSharedPreferences("mySharedPreferences", Context.MODE_PRIVATE)

        val retrievedText = sharedPreferences.getString("NAME", "")

        editText.setText(retrievedText)

        button.setOnClickListener {

            val input = editText.text.toString()
            //Store this text to shared preferences

            val editor = sharedPreferences.edit()

            editor.putString("NAME", input)

            editor.apply()
        }

    }
}
