package com.codingblocks.fragments.ui.activity

import android.arch.persistence.room.Room
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.codingblocks.fragments.ClickHandler
import com.codingblocks.fragments.R
import com.codingblocks.fragments.db.NoteDatabase
import com.codingblocks.fragments.models.Note

class EditActivity : AppCompatActivity(), ClickHandler {

    override fun handleNoteSave(note: Note?) {
        note?.let {
            db.noteDao().updateNote(it)
        }
        finish()
    }

    private val db by lazy {
        Room.databaseBuilder(
            this,
            NoteDatabase::class.java,
            "notesDb.db"
        )
            .allowMainThreadQueries()
            .build()
    }

    override fun handleClick() {

    }

    override fun handleLongNoteClick(note: Note) {
    }

    override fun handleNoteClick(note: Note) {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)
    }

}