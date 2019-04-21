package com.codingblocks.firebasedatabase

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        FirebaseDatabase.getInstance().setPersistenceEnabled(true)


//        if (FirebaseAuth.getInstance().currentUser == null){
//            //User isn't logged in
//        }else{
//            //User is logged in
//        }

        /**
         * The authStateListener callback is called when :
         * 1. As soon as the listener is attached
         * 2. User logs in
         * 3. User logs out
         */
        FirebaseAuth.getInstance().addAuthStateListener {

            FirebaseAuth.getInstance().currentUser?.let {
                //Logged in
                addListenerToDatabase(it)
            } ?: run {
                //User isn't logged in
                authenticate()
            }

        }

    }

    private fun authenticate() {
        //Logic for authentication goes here
//        addListenerToDatabase()
    }

    private fun addListenerToDatabase(it: FirebaseUser) {
        val dbRef = FirebaseDatabase.getInstance().reference
        //Gives me the access to the current user's node
        val currentUserRef = dbRef.child(it.uid)

        currentUserRef.addChildEventListener(object : ChildEventListener {
            override fun onCancelled(dbErr: DatabaseError) {

            }

            override fun onChildMoved(datasnapShot: DataSnapshot, key: String?) {
            }

            override fun onChildChanged(datasnapShot: DataSnapshot, key: String?) {
            }

            override fun onChildAdded(datasnapShot: DataSnapshot, key: String?) {

                val result = datasnapShot.getValue(Notes::class.java)
//                FirebaseDatabase.getInstance().reference.child("users")
//                    .child(books.uid)
//                    .addListenerForSingleValueEvent(object : ValueEventListener{
//                        override fun onDataChange(p0: DataSnapshot) {
//                            val user = p0.getValue(User::class.java)
//                            result.setUse = user
//                        }
//
//                        override fun onCancelled(p0: DatabaseError) {
//                            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//                        }
//
//                    })

            }

            override fun onChildRemoved(datasnapShot: DataSnapshot) {

            }

        })


//        currentUserRef.addValueEventListener(object : ValueEventListener{
//            override fun onCancelled(p0: DatabaseError) {
//
//            }
//
//            override fun onDataChange(p0: DataSnapshot) {
//
//            }
//
//        })

    }
}
