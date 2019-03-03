package com.codingblocks.roomdb

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_row.view.*

class NoteAdapter(private val notes: ArrayList<Note>, val db: NoteDatabase) :
    RecyclerView.Adapter<NoteAdapter.NoteHolder>() {

    lateinit var context: Context

    override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): NoteHolder {
        context = viewGroup.context
        return NoteHolder(LayoutInflater.from(context).inflate(R.layout.item_row, viewGroup, false))
    }

    override fun getItemCount() = notes.size

    override fun onBindViewHolder(noteHolder: NoteHolder, position: Int) {
        val currentNote = notes[position]

//        noteHolder.itemView.tvTitle.text = currentNote.title
//        noteHolder.itemView.tvSubTitle.text = currentNote.subTitle

        noteHolder.itemView.setOnLongClickListener {
            deleteNote(db, position)
        }

        with(noteHolder.itemView) {
            tvTitle.text = currentNote.title
            tvSubTitle.text = currentNote.subTitle
        }
    }

    private fun deleteNote(db: NoteDatabase, position: Int): Boolean {
        val currentNote = notes[position]
        db.noteDao().deleteNote(currentNote)
        notes.removeAt(position)
        notifyItemRemoved(position)
        return true
    }

    inner class NoteHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}