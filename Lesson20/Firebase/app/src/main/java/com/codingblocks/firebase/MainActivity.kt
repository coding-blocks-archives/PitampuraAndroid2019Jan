package com.codingblocks.firebase

import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import com.google.firebase.FirebaseException
import com.google.firebase.auth.*
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_dialog_et.view.*
import java.util.concurrent.TimeUnit
import java.util.regex.Pattern

val VALID_EMAIL_ADDRESS_REGEX: Pattern =
    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE)

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvUserName.setOnClickListener {

            val inflatedView = LayoutInflater.from(this).inflate(R.layout.item_dialog_et, null, false)

            AlertDialog.Builder(this)
                .setMessage("Update Your Name")
                .setView(inflatedView)
                .setPositiveButton("Update") { it, which ->
                    val name = inflatedView.etUpdate.text.toString()

                    val userProfileChangeRequest = UserProfileChangeRequest.Builder()
                        .setDisplayName(name)
                        .build()

                    FirebaseAuth.getInstance().currentUser
                        ?.updateProfile(userProfileChangeRequest)
                        ?.addOnSuccessListener {
                            updateUi(FirebaseAuth.getInstance().currentUser!!)
                        }
                }
                .setNegativeButton("Cancel") { it, which ->

                    it.dismiss()
                }
                .show()
        }

        ivUserImage.setOnClickListener {

            val inflatedView = LayoutInflater.from(this).inflate(R.layout.item_dialog_et, null, false)

            AlertDialog.Builder(this)
                .setMessage("Update Your Image")
                .setView(inflatedView)
                .setPositiveButton("Update") { it, which ->
                    val name = inflatedView.etUpdate.text.toString()

                    val userProfileChangeRequest = UserProfileChangeRequest.Builder()
                        .setPhotoUri(Uri.parse(name))
                        .build()

                    FirebaseAuth.getInstance().currentUser
                        ?.updateProfile(userProfileChangeRequest)
                        ?.addOnSuccessListener {
                            updateUi(FirebaseAuth.getInstance().currentUser!!)
                        }
                }
                .setNegativeButton("Cancel") { it, which ->
                    it.dismiss()
                }
                .show()
        }

        btnLogin.setOnClickListener {
            val email = etEmail.text.toString()
            val password = etPassword.text.toString()
            FirebaseAuth.getInstance()
                .signInWithEmailAndPassword(email, password)
                .addOnSuccessListener {
                    updateUi(it.user)
                }
                .addOnFailureListener {
                    it.printStackTrace()
                }
                .addOnCompleteListener {

                }
        }

        btnSignUp.setOnClickListener {
            val email = etEmail.text.toString()
            val password = etPassword.text.toString()

            FirebaseAuth.getInstance()
                .createUserWithEmailAndPassword(email, password)
                .addOnSuccessListener {
                    updateUi(it.user)
                    it.user.sendEmailVerification()
                }
                .addOnFailureListener {
                    it.printStackTrace()
                }
        }

        btnLogout.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            llLogin.visibility = View.VISIBLE
            llUserProfile.visibility = View.GONE
        }

        //To check for a valid email address
        etEmail.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (validate(s.toString())) {
                    //Valid email
                } else {
                    //Invalid email
                    etEmail.error = "Invalid Email"
                }

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

        })

        btnPhoneVerification.setOnClickListener {

            PhoneAuthProvider.getInstance()
                .verifyPhoneNumber(
                    etPhone.text.toString(),
                    120,
                    TimeUnit.SECONDS,
                    this,
                    object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

                        override fun onVerificationCompleted(authCreds: PhoneAuthCredential?) {

                            FirebaseAuth.getInstance()
                                .signInWithCredential(authCreds!!)
                                .addOnSuccessListener {
                                    updateUi(it.user)
                                }
                                .addOnFailureListener {

                                }
                        }

                        override fun onVerificationFailed(exception: FirebaseException?) {
                            exception?.printStackTrace()
                        }

                    }
                )

        }

    }

    fun validate(emailStr: String): Boolean {
        val matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr)
        return matcher.find()
    }

    override fun onStart() {
        super.onStart()
        val currentUser = FirebaseAuth.getInstance().currentUser

        currentUser?.let {
            //User is not null
            //Show the info of the user on the screen
            updateUi(it)
        } ?: kotlin.run {
            llLogin.visibility = View.VISIBLE
            llUserProfile.visibility = View.GONE
            //User is null
            //Show a Toast that asks the user to login/sign up
            Toast.makeText(this, "Please login or sign up!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun updateUi(it: FirebaseUser) {
        llLogin.visibility = View.GONE
        llUserProfile.visibility = View.VISIBLE
        tvUserName.text = it.displayName
        tvUserUID.text = it.uid
        tvUserEmail.text = it.email
        Picasso.get().load(it.photoUrl).into(ivUserImage)
    }
}
