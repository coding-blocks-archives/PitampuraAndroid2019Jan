package com.codingblocks.fragments.ui.adapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.codingblocks.fragments.ClickHandler
import com.codingblocks.fragments.R
import com.codingblocks.fragments.db.NoteDatabase
import com.codingblocks.fragments.models.Note
import com.codingblocks.fragments.ui.activity.EditActivity
import kotlinx.android.synthetic.main.item_row.view.*

class NoteAdapter(private val notes: ArrayList<Note>, private val handler: ClickHandler) :
    RecyclerView.Adapter<NoteAdapter.NoteHolder>() {

    lateinit var context: Context

    override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): NoteHolder {
        context = viewGroup.context
        return NoteHolder(LayoutInflater.from(context).inflate(R.layout.item_row, viewGroup, false))
    }

    override fun getItemCount() = notes.size

    override fun onBindViewHolder(noteHolder: NoteHolder, position: Int) {
        val currentNote = notes[position]

        noteHolder.itemView.tvTitle.text = currentNote.title
        noteHolder.itemView.tvSubTitle.text = currentNote.subTitle

        noteHolder.itemView.setOnLongClickListener {
            handler.handleLongNoteClick(currentNote)
            true
        }

        noteHolder.itemView.setOnClickListener {
            handler.handleNoteClick(currentNote)
        }

        with(noteHolder.itemView) {
            tvTitle.text = currentNote.title
            tvSubTitle.text = currentNote.subTitle
        }
    }

    private fun deleteNote(db: NoteDatabase, position: Int): Boolean {
        val currentNote = notes[position]

        return true
    }

    inner class NoteHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}