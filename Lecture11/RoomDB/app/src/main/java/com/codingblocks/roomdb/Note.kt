package com.codingblocks.roomdb

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.Ignore
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "note_table")
class Note(
    @ColumnInfo(name = "column_title") val title: String,
    val subTitle: String,
    @PrimaryKey(autoGenerate = true) val id: Int = 0
)

@Entity
class User(val name : String,
           val surName : String)