package com.codingblocks.kotlin

import android.content.Context
import android.widget.Toast

const val NUMBER_OF_TRIALS = 6

fun showShortToast(context: Context, string: String) = Toast.makeText(context, string, Toast.LENGTH_SHORT).show()

fun showLongToast(context: Context, string: String) = Toast.makeText(context, string, Toast.LENGTH_LONG).show()


fun main() {
    val mango = Mango("Sweet", "2982368724", "Delhi")

    val place = mango.origin

}