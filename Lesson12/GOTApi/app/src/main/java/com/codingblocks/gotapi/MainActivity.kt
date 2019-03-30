package com.codingblocks.gotapi

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.codingblocks.gotapi.model.GOTApiResponse
import com.codingblocks.gotapi.model.PlaceHolerPost
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import java.io.IOException

class MainActivity : AppCompatActivity() {

//    val categories = arrayOf("Books", "Characters", "Movies")
//    val characterNames = arrayOf("Jon Snow", "Ned Stark", "Deneyres Targareyan")
//
//    val spinnerCategories
//    val spinnerCharacterNames

    val BASE_URL = "https://anapioficeandfire.com/api/"
    val okHttpClient = OkHttpClient()
    val gson = Gson()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        btnSearch.setOnClickListener {
//
//            val endpoint = "$BASE_URL/${categories[spinnerCategories.getSelected]}/characterNames[]}"
//
//        }

        val request = Request.Builder()
            .url("$BASE_URL/characters/583")
            .build()

        okHttpClient.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {

            }

            override fun onResponse(call: Call, response: Response) {
                val result = response.body()!!.string()

                val gotApiResponse: GOTApiResponse = gson.fromJson(result, GOTApiResponse::class.java)

                //https://jsonplaceholder.typicode.com/posts
                val jsonPlaceHolderPosts: Array<PlaceHolerPost> =
                    gson.fromJson(result, Array<PlaceHolerPost>::class.java)
            }

        })


    }
}
