package com.codingblocks.roomlivedata

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import android.arch.persistence.room.Room
import com.codingblocks.roomlivedata.db.NewsDatabase
import com.codingblocks.roomlivedata.model.News

class NewsViewModel(application: Application) : AndroidViewModel(application) {

    private val roomDb by lazy {
        Room.databaseBuilder(application.baseContext, NewsDatabase::class.java, "news_db")
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }

    val result: String = ""

    lateinit var itemsList: LiveData<List<News>>

    fun fetchItemsFromDb(): LiveData<List<News>> {

        //fetch the liveData from the db

        return itemsList
    }


    fun makeNetworkCall(): String {

        if (result.isNotEmpty()) {
            return result
        } else {
            //Make the network call and then return the result
        }

        return ""
    }

}