package com.codingblocks.roomdb.ui.activity

import android.arch.persistence.room.Room
import android.content.DialogInterface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.codingblocks.roomdb.R
import com.codingblocks.roomdb.`interface`.ClickHandlers
import com.codingblocks.roomdb.db.NoteDatabase
import com.codingblocks.roomdb.model.Note
import com.codingblocks.roomdb.ui.adapter.ItemAdapter
import kotlinx.android.synthetic.main.activity_offline_notes.*

class OfflineNotesActivity : AppCompatActivity(), ClickHandlers{

    private val offlineNotes = arrayListOf<Note>()
    lateinit var notesAdapter: ItemAdapter
    private val db by lazy {
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
        setContentView(R.layout.activity_offline_notes)

        notesAdapter = ItemAdapter(offlineNotes, this)

        rvOfflineNotes.layoutManager = LinearLayoutManager(this)
        rvOfflineNotes.adapter = notesAdapter

    }

    override fun handleClick(note: Note) {
        Toast.makeText(this, "Upload started", Toast.LENGTH_SHORT).show()
        //Upload the note to a cloud server
    }

    override fun handleLongClick(note: Note) {
        Toast.makeText(this, "Note Deleted", Toast.LENGTH_SHORT).show()
        db.noteDao().deleteNote(note)
        offlineNotes.remove(note)
        notesAdapter.notifyDataSetChanged()
    }

}
