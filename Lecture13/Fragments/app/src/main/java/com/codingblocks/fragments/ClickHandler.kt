package com.codingblocks.fragments

import com.codingblocks.fragments.models.Note

interface ClickHandler {
    fun handleClick()
    fun handleLongNoteClick(note: Note)
    fun handleNoteClick(note: Note)
    fun handleNoteSave(note : Note?)

}