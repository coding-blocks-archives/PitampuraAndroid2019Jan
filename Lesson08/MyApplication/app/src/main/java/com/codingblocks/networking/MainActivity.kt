package com.codingblocks.networking

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.io.InputStream
import java.lang.StringBuilder
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLConnection
import java.util.*
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnGo.setOnClickListener {

            //Get the input URL
            val stringUrl: String = "https://cat-fact.herokuapp.com/facts"

            //Convert the URL String to a fully formatted URL Object
            val url = URL(stringUrl)

            //Open a connection between the device and the URL
            val urlConnection: HttpURLConnection = url.openConnection() as HttpURLConnection

            thread {
                //Get the stream of data from the connection
                val inputStream: InputStream = urlConnection.inputStream

                //Create a scanner and initialize it with the input stream
                val scanner = Scanner(inputStream)

                //Instructs the Scanner to read the entire content of the InputStream in One Go
                scanner.useDelimiter("\\A")

                //Sanity check to ensure we don't get `null` from the scanner's next() method
                if (scanner.hasNext()) {
                    val result = scanner.next()
                    runOnUiThread {
                        tvContent.text = result
                    }
                }
            }

//            val response: StringBuilder = StringBuilder()

            //Until the last element of Stream is reached, keep on reading from the stream and
            //append the received data to StringBuilder
//            while (scanner.hasNext()) {
//                response.append(scanner.next())
//            }

            //Save the result as a String
//            val result = response.toString()

        }

    }
}
