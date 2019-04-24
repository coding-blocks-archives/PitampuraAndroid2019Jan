package com.codingblocks.roomlivedata

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.arch.persistence.room.Room
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.codingblocks.roomlivedata.db.NewsDatabase
import com.codingblocks.roomlivedata.model.News

class MainActivity : AppCompatActivity() {

    val news = arrayListOf<News>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val newsViewModel = ViewModelProviders.of(this).get(NewsViewModel::class.java)

        val result = newsViewModel.makeNetworkCall()

        newsViewModel.fetchItemsFromDb()
            .observeForever {
                it?.let {
                    news.clear()
                    news.addAll(it)
                    // notify your adapter
                }
                //Clear your data source
                //Add this newsList to your data source
                //Notify the adapter

            }
    }
}
