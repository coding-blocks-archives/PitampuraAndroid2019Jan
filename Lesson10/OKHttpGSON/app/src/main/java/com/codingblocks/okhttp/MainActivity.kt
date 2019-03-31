package com.codingblocks.okhttp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import java.io.IOException


class MainActivity : AppCompatActivity() {

    private val catFacts = "https://pokeapi.co/api/v2/pokemon/25"
    private val gson = Gson()
    private val postUrl = "http://ptsv2.com/t/w9o7h-1551509762/post"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val client = OkHttpClient()

        val request = Request.Builder()
            .url(catFacts)
            .build()


//        tvName.setOnClickListener(object : View.OnClickListener{
//            override fun onClick(v: View?) {
//
//            }
//
//        })
//
//        tvName.setOnClickListener {
//
//            //it here refers to the view that was clicked
//
//        }

        val call: Call = client.newCall(request)

        call.enqueue(object : Callback {

            override fun onFailure(call: Call, e: IOException) {
                e.printStackTrace()
                call.enqueue(this)
            }

            override fun onResponse(call: Call, response: okhttp3.Response) {

//                val pokemon = gson.fromJson(response.body.string(), Pokemon::class.java)
//
//                db.save(pokemon)
//
//                val pokemon = db.getPokemon("pikachu")
//
//                runOnUIThread{

//                }

                val responseBody: ResponseBody? = response.body()

                val result = responseBody?.string()

                val parsedObject: Response = gson.fromJson(result, Response::class.java)

                Log.e("TAG", parsedObject.species.name)
            }

        })

//        val response = client.newCall(request).execute()
//
//        val responseBody = response.body()
//
//        val result = responseBody?.string()

//        Log.e("TAG", result)

//        val request2 = Request.Builder()
//            .url(catFacts)
//            .build()
//
//        val response2 = client.newCall(request2).execute()

    }
}
