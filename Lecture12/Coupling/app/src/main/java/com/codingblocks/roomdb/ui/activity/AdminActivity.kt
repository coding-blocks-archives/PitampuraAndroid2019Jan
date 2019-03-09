package com.codingblocks.roomdb.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.codingblocks.roomdb.R
import com.codingblocks.roomdb.`interface`.ClickHandlers
import com.codingblocks.roomdb.model.Note
import com.codingblocks.roomdb.ui.adapter.ItemAdapter

class AdminActivity : AppCompatActivity(), ClickHandlers {

    override fun handleClick(note: Note) {
    }

    override fun handleLongClick(note: Note) {
    }

    private val notes = arrayListOf<Note>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin)

        val adapter = ItemAdapter(notes, this)
    }
}
