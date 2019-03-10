package com.codingblocks.fragments.ui.fragment

import android.arch.persistence.room.Room
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AlertDialog
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.codingblocks.fragments.ClickHandler
import com.codingblocks.fragments.R
import com.codingblocks.fragments.db.NoteDatabase
import com.codingblocks.fragments.models.Note
import com.codingblocks.fragments.ui.activity.EditActivity
import com.codingblocks.fragments.ui.adapter.NoteAdapter
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*
import kotlinx.android.synthetic.main.item_row.view.*
import kotlinx.android.synthetic.main.view_dialog.view.*

class HomeFragment : Fragment() {

    private val db by lazy {
        Room.databaseBuilder(
            requireContext(),
            NoteDatabase::class.java,
            "notesDb.db"
        )
            .allowMainThreadQueries()
            .build()
    }

    private val notesList = arrayListOf<Note>()
    lateinit var noteAdapter: NoteAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        notesList.addAll(db.noteDao().getNotes())

        noteAdapter = NoteAdapter(notesList, (activity as ClickHandler))
        rvNotes.layoutManager = LinearLayoutManager(requireContext())

        rvNotes.adapter = noteAdapter

        view.fabAdd.setOnClickListener {
            showCustomAlert()
        }
    }

    private fun showCustomAlert() {

        val dialogView = LayoutInflater.from(requireContext()).inflate(R.layout.view_dialog, null, false)

        val customAlertDialog = AlertDialog.Builder(requireContext())
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
                noteAdapter.notifyItemInserted(0)

                (activity as ClickHandler).handleClick()
            }
            .setNegativeButton("Close") { dialog, which ->
                dialog.cancel()
            }
            .create()

        customAlertDialog.show()
    }

}