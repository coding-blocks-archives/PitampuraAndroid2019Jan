package com.codingblocks.room

import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.view_dialog.*
import kotlinx.android.synthetic.main.view_dialog.view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        floatingActionButton.setOnClickListener {
            showCustomAlert()
        }
    }

    private fun showSimpleAlert() {

        val simpleAlert = AlertDialog.Builder(this)
            .setTitle("Hi I'm a simple alert!")
            .setMessage("Nice to meet you...")
            .setPositiveButton("Ok") { dialog, _ ->
                dialog.cancel()
            }
            .setNegativeButton("Close") { dialog, _ ->
                dialog.cancel()
            }
            .setCancelable(false)
            .create()

        simpleAlert.show()
    }

    private val itemsArray = arrayOf("Item 1", "Item 2", "Item 3", "Item 4")
    private val checkedArray = booleanArrayOf(false, false, false, false)

    fun showMultiChoiceAlert() {
        val multiChoiceAlert = AlertDialog.Builder(this)
            .setMultiChoiceItems(
                itemsArray,
                checkedArray
            ) { dialog, which, isChecked ->
                //You get a callback here with the selected item as soon as the user selects it here
                Toast.makeText(this, itemsArray[which], Toast.LENGTH_SHORT).show()
            }
            .setTitle("Multi Select Dialog")
//            .setMessage("Hi!")
            .setPositiveButton("Ok") { dialog, which ->
                dialog.cancel()
            }
            .setNegativeButton("Close") { dialog, which ->
                dialog.cancel()
            }
            .create()

        multiChoiceAlert.show()
    }

    private fun showSingleChoiceAlert() {
        val singleChoice = AlertDialog.Builder(this)
            .setSingleChoiceItems(
                itemsArray,
                0
            ) { dialog, which ->
                Toast.makeText(this, itemsArray[which], Toast.LENGTH_SHORT).show()
            }
            .setTitle("Multi Select Dialog")
//            .setMessage("Hi!")
            .setPositiveButton("Ok") { dialog, which ->
                dialog.cancel()
            }
            .setNegativeButton("Close") { dialog, which ->
                dialog.cancel()
            }
            .create()

        singleChoice.show()
    }

    private fun showCustomAlert() {

        val dialogView = LayoutInflater.from(this).inflate(R.layout.view_dialog, null, false)

        val customAlertDialog = AlertDialog.Builder(this)
            .setTitle("Hello from a custom alert")
            .setView(dialogView)
            .setPositiveButton("Ok") { dialog, which ->
                dialog.cancel()
                Toast.makeText(
                    this,
                    "Title : ${dialogView.etTitle.text}, Subtitle : ${dialogView.etSubtitle.text}",
                    Toast.LENGTH_SHORT
                ).show()
            }
            .setNegativeButton("Close") { dialog, which ->
                dialog.cancel()
            }
            .create()


        customAlertDialog.show()

    }


}