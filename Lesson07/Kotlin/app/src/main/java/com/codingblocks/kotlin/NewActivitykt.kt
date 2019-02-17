package com.codingblocks.kotlin

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.ColorRes
import android.support.v4.content.ContextCompat
import android.support.v4.view.ViewCompat
import android.support.v7.widget.Toolbar
import kotlinx.android.synthetic.main.activity_new_activitykt.*

class NewActivitykt : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_activitykt)
        savedInstanceState?.putFloat("KEY", 1F)
        getMyColor(this, R.color.colorAccent)


    }

}




fun getMyColor(context: Context?, @ColorRes color: Int): Int? {
//    val color: Int? = context?.resources?.getColor(color)

    val returnedColor: Int

    context?.let { ctx ->
        returnedColor = ContextCompat.getColor(ctx, color)
    }

    return color
}
