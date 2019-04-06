package com.codingblocks.permissions

import android.Manifest
import android.content.Intent
import android.content.Intent.ACTION_CALL
import android.content.pm.PackageManager
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var callIntent: Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCall.setOnClickListener {
            val input = "tel:${etNumber.text}"
            callIntent = Intent(ACTION_CALL).apply {
                data = Uri.parse(input)
            }

            if (
                ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.CALL_PHONE
                )
                == PackageManager.PERMISSION_GRANTED
            ) {
                startActivity(callIntent)
                //If the permission is granted
//                Toast.makeText(this, "Thank you for granting the permissions", Toast.LENGTH_SHORT).show()
            } else {
                //else request permissions
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.CALL_PHONE, Manifest.permission.SEND_SMS),
                    12345
                )
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode == 12345) {
            //This is the callback for phone permission

            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                //I have the calling permission
                startActivity(callIntent)

            } else {
                //Permission has been denied by the user, show him/her a toast
                Toast.makeText(this, "Sorry, I will need the calling permission to make calls", Toast.LENGTH_SHORT).show()
            }

        }

    }

}
