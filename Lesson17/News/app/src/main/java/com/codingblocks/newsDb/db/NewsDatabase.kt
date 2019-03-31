package com.codingblocks.newsDb.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.codingblocks.newsDb.model.News

@Database(entities = [News::class], version = 3)
abstract class NewsDatabase : RoomDatabase() {
    abstract fun getNewsDao(): NewsDao
}