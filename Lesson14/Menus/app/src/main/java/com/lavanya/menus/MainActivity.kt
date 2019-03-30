package com.lavanya.menus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true

    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        when (item?.itemId) {
            R.id.home -> {
                Toast.makeText(baseContext, "clicked on home", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.profile -> {
                Toast.makeText(baseContext, "clicked on profile", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.about -> {
                Toast.makeText(baseContext, "clicked on about", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.settings -> {
                Toast.makeText(baseContext, "clicked on settings", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.sub1 -> {
                Toast.makeText(baseContext, "clicked on sub1", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.sub2 -> {
                Toast.makeText(baseContext, "clicked on sub2", Toast.LENGTH_SHORT).show()
                return true
            }


        }
        return true
    }
}
