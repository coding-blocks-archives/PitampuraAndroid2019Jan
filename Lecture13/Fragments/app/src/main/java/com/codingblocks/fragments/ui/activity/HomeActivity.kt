package com.codingblocks.fragments.ui.activity

import android.arch.persistence.room.Room
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.FrameLayout
import android.widget.Toast
import com.codingblocks.fragments.ClickHandler
import com.codingblocks.fragments.R
import com.codingblocks.fragments.db.NoteDatabase
import com.codingblocks.fragments.models.Note
import com.codingblocks.fragments.ui.fragment.EditFragment
import kotlinx.android.synthetic.main.activity_main.*

class HomeActivity : AppCompatActivity(), ClickHandler {

    override fun handleNoteSave(note: Note?) {
        note?.let {
            db.noteDao().updateNote(it)
        }
        Toast.makeText(this, "Note Updated", Toast.LENGTH_SHORT).show()
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

    override fun handleLongNoteClick(note: Note) {
        //Start the new activity with the information about the currently clicked note
        db.noteDao().deleteNote(note)
    }

    override fun handleNoteClick(note: Note) {

        //Have a check to see if the Activity is in portrait or landscape mode
        //If in portrait, start a new Intent for the EditActivity
        //If in landscape, start a new EditFragment with the data for the clicked note

        if (container == null) {
            val intent = Intent(this, EditActivity::class.java)
            intent.putExtra("ID", note.id)
            Log.e("TAG", "ID is ${note.id}")
            startActivity(intent)
        } else {
            //Start a new fragment
            val editFragment = EditFragment(note)

            supportFragmentManager.beginTransaction()
                .replace(R.id.container, editFragment)
                .commit()
        }

    }

    override fun handleClick() {
        Toast.makeText(this, "Note Saved to the db", Toast.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
