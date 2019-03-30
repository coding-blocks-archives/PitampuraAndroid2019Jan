package com.codingblocks.roomdb.ui.activity

import android.arch.persistence.room.Room
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.codingblocks.roomdb.R
import com.codingblocks.roomdb.db.NoteDatabase
import kotlinx.android.synthetic.main.activity_edit.*

class EditActivity : AppCompatActivity() {

    val db by lazy {
        Room.databaseBuilder(
            this,
            NoteDatabase::class.java,
            "notesDb.db"
        )
            .allowMainThreadQueries()
            .build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)
        val id = intent.getIntExtra("ID", 0)

        val note = db.noteDao().getNoteById(id)

        etTitleEdit.setText(note.title, TextView.BufferType.EDITABLE)
        etSubtitleEdit.setText(note.subTitle, TextView.BufferType.EDITABLE)

        fabSave.setOnClickListener {

            note.title = etTitleEdit.text.toString()
            note.subTitle = etSubtitleEdit.text.toString()

            db.noteDao().updateNote(note)

            finish()
        }

    }
}
