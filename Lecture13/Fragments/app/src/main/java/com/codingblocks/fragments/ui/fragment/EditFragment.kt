package com.codingblocks.fragments.ui.fragment

import android.arch.persistence.room.Room
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.codingblocks.fragments.ClickHandler
import com.codingblocks.fragments.R
import com.codingblocks.fragments.db.NoteDatabase
import com.codingblocks.fragments.models.Note
import kotlinx.android.synthetic.main.fragment_edit.*
import kotlinx.android.synthetic.main.fragment_edit.view.*

class EditFragment : Fragment {

    private val db by lazy {
        Room.databaseBuilder(
            requireContext(),
            NoteDatabase::class.java,
            "notesDb.db"
        )
            .allowMainThreadQueries()
            .build()
    }

    var note: Note? = null

    constructor() : super()

    constructor(receivedNote: Note) : super() {
        note = receivedNote
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_edit, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val id = requireActivity().intent.getIntExtra("ID", 0)

        if (note == null){
            note = db.noteDao().getNoteById(id)
        }

        view.etTitleEdit.setText(note?.title)
        view.etSubtitleEdit.setText(note?.subTitle)
        fabSave.setOnClickListener {
            note?.title = etTitleEdit.text.toString()
            note?.subTitle = etSubtitleEdit.text.toString()

            (activity as ClickHandler).handleNoteSave(note)
        }
    }


}