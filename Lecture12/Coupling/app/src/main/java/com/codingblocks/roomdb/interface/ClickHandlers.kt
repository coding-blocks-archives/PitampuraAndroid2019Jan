package com.codingblocks.roomdb.`interface`

import com.codingblocks.roomdb.model.Note

interface ClickHandlers {

    fun handleClick(note: Note)

    fun handleLongClick(note: Note)

}