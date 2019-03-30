package com.codingblocks.roomdb.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.codingblocks.roomdb.models.Note

@Database(entities = [Note::class], version = 1)
abstract class NoteDatabase : RoomDatabase() {

    abstract fun noteDao(): NotesDao

}