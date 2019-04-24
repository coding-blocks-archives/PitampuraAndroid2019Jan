package com.codingblocks.roomlivedata.db

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.codingblocks.roomlivedata.model.News

@Dao
interface NewsDao {

    @Insert
    fun insertNews(news: News)

    @Insert
    fun insertMultipleNews(newsList: List<News>)

    @Query("SELECT * FROM news WHERE type = :typeOfNews")
    fun getAllNews(typeOfNews: String): LiveData<List<News>>

    @Query("DELETE FROM news WHERE type = :typeOfNews")
    fun deleteNewsOfType(typeOfNews: String)

}