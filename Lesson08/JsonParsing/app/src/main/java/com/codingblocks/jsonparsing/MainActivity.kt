package com.codingblocks.jsonparsing

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL
import java.util.*
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    val responses = arrayListOf<Response>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnGo.setOnClickListener {

            thread {
                val result: String = makeNetworkCall()

                //Extract content from the result

                val jsonResult = JSONObject(result)

                val resultArray = jsonResult.optJSONArray("all")

                for (i in 0..resultArray.length() - 1) {

                    val currentResult = resultArray.optJSONObject(i)

                    val text = currentResult.optString("text")

                    val jsonUser: JSONObject? = currentResult.optJSONObject("user")

                    val jsonName = jsonUser?.optJSONObject("name")

//                    jsonName?.let {
//                        val first = it.optString("first")
//                        val last = it.optString("last")
//                    }

                    //?: (elvis operator) is a alternate for the `else` block for null check

                    val first = jsonName?.optString("first") ?: ""
//
                    val last = jsonName?.optString("last") ?: ""

                    val name = Name(first, last)

                    val user = User(name)

                    val response = Response(text, user)
                    responses.add(response)
                }

                runOnUiThread {
                    val i = Random().nextInt(responses.size - 1)
                    Log.e("TAG", "Text : ${responses[i].text}")
                    Log.e("TAG", "User : ${responses[i].user.name.first}  ${responses[i].user.name.last}")

                    //Notify the adapter

                }

            }

        }

    }


    fun makeNetworkCall(): String {
        //Get the input URL
        val stringUrl: String = "https://cat-fact.herokuapp.com/facts"

        //Convert the URL String to a fully formatted URL Object
        val url = URL(stringUrl)

        //Open a connection between the device and the URL
        val urlConnection: HttpURLConnection = url.openConnection() as HttpURLConnection

        //Get the stream of data from the connection
        val inputStream: InputStream = urlConnection.inputStream

        //Create a scanner and initialize it with the input stream
        val scanner = Scanner(inputStream)

        //Instructs the Scanner to read the entire content of the InputStream in One Go
        scanner.useDelimiter("\\A")

        var result: String = ""

        //Sanity check to ensure we don't get `null` from the scanner's next() method
        if (scanner.hasNext()) {
            result = scanner.next()
        }

        return result
    }

}
