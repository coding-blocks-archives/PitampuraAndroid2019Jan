package com.codingblocks.fragments.models

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.Ignore
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "note_table")
class Note(
    @ColumnInfo(name = "column_title") var title: String,
    var subTitle: String,
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)