package com.codingblocks.callbacks

import android.arch.lifecycle.ViewModel
import okhttp3.*
import java.io.IOException

class MainViewModel : ViewModel() {

    private var result = ""

    private val okHttpClient = OkHttpClient.Builder().build()
    private val request = Request.Builder().url("https://api.github.com/search/users?q=harshit").build()

    fun fetchUsersFromApi(cb: CallbackInterface) {

        if (result.isNotEmpty()) {
            return cb.onResult(result)
        } else {
            okHttpClient.newCall(request)
                .enqueue(object : Callback {

                    override fun onFailure(call: Call, e: IOException) {
                        result = ""
                        cb.onResult(result)
                    }

                    override fun onResponse(call: Call, response: Response) {
                        result = response.body()?.string() ?: ""
                        cb.onResult(result)
                    }

                })
        }
    }

    fun fetchUsersFromApiCb(cb: (String, Int) -> Unit) {

        if (result.isNotEmpty()) {
            return cb(result, 1)
        } else {
            okHttpClient.newCall(request)
                .enqueue(object : Callback {

                    override fun onFailure(call: Call, e: IOException) {
                        result = ""
                        cb(result, 1)
                    }

                    override fun onResponse(call: Call, response: Response) {
                        result = response.body()?.string() ?: ""
                        cb(result, 0)
                    }

                })
        }
    }

}