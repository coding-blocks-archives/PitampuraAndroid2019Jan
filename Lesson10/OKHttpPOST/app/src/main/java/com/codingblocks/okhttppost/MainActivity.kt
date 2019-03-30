package com.codingblocks.okhttppost

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.gson.Gson
import okhttp3.*
import java.io.IOException

class MainActivity : AppCompatActivity() {

    private val postUrl = "http://ptsv2.com/t/w9o7h-1551509762/post"
    val gson = Gson()
    val student = Student("Harshit", "Android", 23)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val client = OkHttpClient.Builder().build()

        val mediaType = MediaType.parse("application/json")

        val studentJson = gson.toJson(student)

        val requestBody = RequestBody.create(
            mediaType,
            studentJson
        )

        val request = Request.Builder()
            .url(postUrl)
            .post(requestBody)
            .header("HELLO", "WORLD")
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                e.printStackTrace()
            }

            override fun onResponse(call: Call, response: Response) {
                Log.e("TAG", response.body()?.string())
            }

        })

    }
}
