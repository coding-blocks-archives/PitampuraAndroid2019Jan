package com.codingblocks.fragments.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.codingblocks.fragments.models.Note

@Database(entities = [Note::class], version = 1)
abstract class NoteDatabase : RoomDatabase() {

    abstract fun noteDao(): NotesDao

}