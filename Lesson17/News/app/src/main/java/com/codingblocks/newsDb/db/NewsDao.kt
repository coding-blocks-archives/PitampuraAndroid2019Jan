package com.codingblocks.newsDb.db

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.codingblocks.newsDb.model.News

@Dao
interface NewsDao {

    @Insert
    fun insertNews(news: News)

    @Insert
    fun insertMultipleNews(newsList: List<News>)

    @Query("SELECT * FROM news WHERE type = :typeOfNews")
    fun getAllNews(typeOfNews: String): List<News>

    @Query("DELETE FROM news WHERE type = :typeOfNews")
    fun deleteNewsOfType(typeOfNews: String)

}