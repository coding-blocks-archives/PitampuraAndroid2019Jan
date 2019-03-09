package com.codingblocks.gotapi.model

class GOTApiResponse(
    val name : String,
    val gender : String,
    val culture : String,
    val born : String,
    val died : String,
    val titles : ArrayList<String>,
    val aliases : ArrayList<String>,
    val books : ArrayList<String>,
    val playedBy : ArrayList<String>
)