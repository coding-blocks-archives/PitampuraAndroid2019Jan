package com.codingblocks.jsonparsing

class Response(val text: String, val user: User)

class User(val name: Name)

class Name(val first: String, val last: String)