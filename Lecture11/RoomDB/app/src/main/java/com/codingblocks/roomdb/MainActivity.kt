package com.codingblocks.roomdb

import android.arch.persistence.room.Room
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.view_dialog.view.*

class MainActivity : AppCompatActivity() {

//    val db = Room.databaseBuilder(
//        this,
//        NoteDatabase::class.java,
//        "notesDb.db"
//    )
//        .build()

    val db by lazy {
        Room.databaseBuilder(
            this,
            NoteDatabase::class.java,
            "notesDb.db"
        )
            .allowMainThreadQueries()
            .build()
    }

    private val notesList = arrayListOf<Note>()
    lateinit var noteAdapter: NoteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        notesList.addAll(db.noteDao().getNotes())

        noteAdapter = NoteAdapter(notesList, db)

        rvNotes.layoutManager = LinearLayoutManager(this)

        rvNotes.adapter = noteAdapter

        floatingActionButton.setOnClickListener {
            showCustomAlert()
        }
    }

    private fun showCustomAlert() {

        val dialogView = LayoutInflater.from(this).inflate(R.layout.view_dialog, null, false)

        val customAlertDialog = AlertDialog.Builder(this)
            .setTitle("Hello from a custom alert")
            .setView(dialogView)
            .setPositiveButton("Ok") { dialog, which ->
                dialog.cancel()
                val title = dialogView.etTitle.text.toString()
                val subTitle = dialogView.etSubtitle.text.toString()
                val note = Note(title, subTitle)
                db.noteDao().insertNote(note)

                notesList.add(note)
                noteAdapter.notifyItemInserted(notesList.size - 1)
            }
            .setNegativeButton("Close") { dialog, which ->
                dialog.cancel()
            }
            .create()

        customAlertDialog.show()
    }
}
