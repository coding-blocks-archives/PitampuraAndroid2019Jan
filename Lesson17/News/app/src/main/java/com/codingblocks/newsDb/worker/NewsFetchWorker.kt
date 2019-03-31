package com.codingblocks.newsDb.worker

import android.arch.persistence.room.Room
import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.codingblocks.newsDb.R
import com.codingblocks.newsDb.db.NewsDatabase
import com.codingblocks.newsDb.model.News
import com.codingblocks.newsDb.model.NewsResponse
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.Request

class NewsFetchWorker(context: Context, workerParams: WorkerParameters) : Worker(context, workerParams) {

    private val okhttpClient = OkHttpClient.Builder().build()
    private val gson = Gson()

    private val newsDatabase by lazy {
        Room.databaseBuilder(applicationContext, NewsDatabase::class.java, "news.db")
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }

    private val newsDao by lazy {
        newsDatabase.getNewsDao()
    }

    override fun doWork(): Result {

        val endpoint = inputData.getString("ENDPOINT") ?: ""

        val url =
            """
                https://newsapi.org/v2/top-headlines?country=us&category=
                $endpoint&apiKey=
                ${applicationContext.resources.getString(R.string.api_key)}
            """.trimIndent()

        val request = Request.Builder()
            .url(url)
            .build()

        val response = okhttpClient.newCall(request).execute()

        val responseString = response.body()?.string()

        val newsResponse = gson.fromJson(responseString, NewsResponse::class.java)

        newsResponse.articles.forEach {
            it.type = endpoint
        }

        newsDao.deleteNewsOfType(endpoint)

        newsDao.insertMultipleNews(newsResponse.articles)

        return Result.success()
    }

}