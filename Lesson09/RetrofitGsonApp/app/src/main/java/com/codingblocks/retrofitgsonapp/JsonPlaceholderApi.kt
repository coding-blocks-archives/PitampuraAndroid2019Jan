package com.codingblocks.retrofitgsonapp

import retrofit2.Call
import retrofit2.http.GET

interface JsonPlaceholderApi {

    @GET("users")
    fun getUsers(): Call<ArrayList<User>>
}