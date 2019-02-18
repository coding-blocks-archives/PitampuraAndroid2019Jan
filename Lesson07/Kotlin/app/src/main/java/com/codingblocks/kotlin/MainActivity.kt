package com.codingblocks.kotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    //vars can be reassigned
    private var count: Int = 0

    //vals can't be reassigned
    val valCount: Int = 0

    lateinit var noteAdapter: NoteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sampleText = "Hello World"

        noteAdapter = NoteAdapter()

        count++
        count--

        val titleNote = Note(title = "sdkjfdsb")

        val descNote = Note(desc = "sdfsdf")


        tvOne.setOnClickListener {

            tvTwo.setTextColor(ContextCompat.getColor(this, R.color.colorAccent))

        }


//        valCount++

        thread {
            //Do background processing here

            runOnUiThread {
                //Do the UI work here
            }
        }

    }

    fun increment() {
        count++
    }

    fun decrement() {
        count--
    }

    fun countSquared(): Int {
        return count * count
    }

    fun singleLineCountSquared() = count * count

    fun showToast(number: Int) {
        Toast.makeText(this, "The number is $number", Toast.LENGTH_SHORT).show()
    }

    fun printEvenOrOdd(number: Int) {

        val isEven = if (number % 2 == 0) true else false

        showShortToast(this, "HEllo world")

        Toast.makeText(this, "The Square of number is : ${countSquared()}", Toast.LENGTH_SHORT).show()

        Toast.makeText(
            this,
            "$number is : ${if (number % 2 == 0) "even" else "odd"}",
            Toast.LENGTH_SHORT
        ).show()
    }

}
