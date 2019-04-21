package com.codingblocks.firebasedatabase

import android.support.annotation.Keep

class Notes(
    @Keep val title: String,
    @Keep val id: Long,
    @Keep val desc: String,
    @Keep val date: Long,
    @Keep val url: String
)
