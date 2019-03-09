package com.codingblocks.roomdb.ui.adapter

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.codingblocks.roomdb.R
import com.codingblocks.roomdb.`interface`.ClickHandlers
import com.codingblocks.roomdb.model.Note
import com.codingblocks.roomdb.ui.activity.MainActivity
import com.codingblocks.roomdb.ui.activity.OfflineNotesActivity
import kotlinx.android.synthetic.main.item_row.view.*

class ItemAdapter(
    private val notes: ArrayList<Note>,
    private val handler: ClickHandlers
) :
    RecyclerView.Adapter<ItemAdapter.NoteHolder>() {

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
            handler.handleLongClick(currentNote)
            //If returned false, both onClick and onLongClick will be called
            return@setOnLongClickListener true
        }

        noteHolder.itemView.setOnClickListener {
            //Start the new activity with the information about the currently clicked note
            handler.handleClick(currentNote)
        }

        with(noteHolder.itemView) {
            tvTitle.text = currentNote.title
            tvSubTitle.text = currentNote.subTitle
        }
    }


    inner class NoteHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}