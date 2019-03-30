package com.codingblocks.roomdb.ui.activity

import android.arch.persistence.room.Room
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import com.codingblocks.roomdb.model.Note
import com.codingblocks.roomdb.ui.adapter.ItemAdapter
import com.codingblocks.roomdb.R
import com.codingblocks.roomdb.`interface`.ClickHandlers
import com.codingblocks.roomdb.db.NoteDatabase
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.view_dialog.view.*

class MainActivity : AppCompatActivity(), ClickHandlers {

//    val db = Room.databaseBuilder(
//        this,
//        NoteDatabase::class.java,
//        "notesDb.db"
//    )
//        .build()

    private val db by lazy {
        Room.databaseBuilder(
            this,
            NoteDatabase::class.java,
            "notesDb.db"
        )
            .allowMainThreadQueries()
            .build()
    }

    private val notesList = arrayListOf<Note>()
    lateinit var itemAdapter: ItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        notesList.addAll(db.noteDao().getNotes())

        itemAdapter = ItemAdapter(notesList, this)

        rvNotes.layoutManager = LinearLayoutManager(this)

        rvNotes.adapter = itemAdapter

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

                //Get the ID of the inserted note
                val id = db.noteDao().insertNote(note)  //if this ID is -1, that means the insertion failed

                //Update the note object so that it has an ID
                note.id = id.toInt()

                //Add the note with an ID to the arrayList
                notesList.add(0, note)

                rvNotes.smoothScrollToPosition(0)
                itemAdapter.notifyItemInserted(0)
            }
            .setNegativeButton("Close") { dialog, which ->
                dialog.cancel()
            }
            .create()

        customAlertDialog.show()
    }

    override fun onResume() {
        super.onResume()
        notesList.clear()
        notesList.addAll(db.noteDao().getNotes())
        itemAdapter.notifyDataSetChanged()
    }

    override fun handleClick(note: Note) {
        val intent = Intent(this, EditActivity::class.java)
        intent.putExtra("ID", note.id)
        Log.e("TAG", "ID is ${note.id}")
        startActivity(intent)
    }

    override fun handleLongClick(note: Note) {
        db.noteDao().deleteNote(note)
        notesList.remove(note)
        itemAdapter.notifyDataSetChanged()
    }

}
