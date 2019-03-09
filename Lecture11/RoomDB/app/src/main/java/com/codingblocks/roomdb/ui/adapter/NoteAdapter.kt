package com.codingblocks.roomdb.ui.adapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.codingblocks.roomdb.R
import com.codingblocks.roomdb.db.NoteDatabase
import com.codingblocks.roomdb.models.Note
import com.codingblocks.roomdb.ui.activity.EditActivity
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

        noteHolder.itemView.setOnClickListener {
            //Start the new activity with the information about the currently clicked note
            val intent = Intent(context, EditActivity::class.java)
            intent.putExtra("ID", currentNote.id)
            Log.e("TAG", "ID is ${currentNote.id}")
            context.startActivity(intent)
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