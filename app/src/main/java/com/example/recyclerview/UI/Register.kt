package com.example.recyclerview.UI

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.recyclerview.R
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import java.util.HashMap


class Register : AppCompatActivity() {
    var mFullName: EditText? = null
    var mEmail: EditText? = null
    var mPassword: EditText? = null
    var mPhone: EditText? = null
    var mRegisterBtn: Button? = null
    var mLoginBtn: TextView? = null
    var fAuth: FirebaseAuth? = null
    var progressBar: ProgressBar? = null
    var fStore: FirebaseFirestore? = null
    var userID: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        mFullName = findViewById(R.id.fullName)
        mEmail = findViewById(R.id.Email)
        mPassword = findViewById(R.id.password)
        mPhone = findViewById(R.id.phone)
        mRegisterBtn = findViewById(R.id.registerBtn)
        mLoginBtn = findViewById(R.id.createText)
        fAuth = FirebaseAuth.getInstance()
        fStore = FirebaseFirestore.getInstance()
        progressBar = findViewById(R.id.progressBar)
        if (fAuth!!.currentUser != null) {
            startActivity(Intent(applicationContext, MainActivity::class.java))
            finish()
        }
        mRegisterBtn!!.setOnClickListener(View.OnClickListener {
            val email = mEmail!!.getText().toString().trim { it <= ' ' }
            val password = mPassword!!.getText().toString().trim { it <= ' ' }
            val fullName = mFullName!!.getText().toString()
            val phone = mPhone!!.getText().toString()
            if (TextUtils.isEmpty(email)) {
                mEmail!!.setError("Email is Required.")
                return@OnClickListener
            }
            if (TextUtils.isEmpty(password)) {
                mPassword!!.setError("Password is Required.")
                return@OnClickListener
            }
            if (password.length < 6) {
                mPassword!!.setError("Password Must be >= 6 Characters")
                return@OnClickListener
            }
            progressBar!!.setVisibility(View.VISIBLE)

            // register the user in firebase
            fAuth!!.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->
                if (task.isSuccessful) {

                    // send verification link
                    val fuser = fAuth!!.currentUser
                    fuser!!.sendEmailVerification().addOnSuccessListener {
                        Toast.makeText(
                            this@Register,
                            "Verification Email Has been Sent.",
                            Toast.LENGTH_SHORT
                        ).show()
                    }.addOnFailureListener { e ->
                        Log.d(
                            TAG,
                            "onFailure: Email not sent " + e.message
                        )
                    }
                    Toast.makeText(this@Register, "User Created.", Toast.LENGTH_SHORT).show()
                    userID = fAuth!!.currentUser!!.uid
                    val documentReference: DocumentReference =
                        fStore!!.collection("users").document(userID!!)
                    val user: MutableMap<String, Any> =
                        HashMap()
                    user["fName"] = fullName
                    user["email"] = email
                    user["phone"] = phone
                    documentReference.set(user).addOnSuccessListener(OnSuccessListener<Void?> {
                        Log.d(
                            TAG,
                            "onSuccess: user Profile is created for $userID"
                        )
                    }).addOnFailureListener(OnFailureListener { e ->
                        Log.d(
                            TAG,
                            "onFailure: $e"
                        )
                    })
                    startActivity(Intent(applicationContext, ProfileActivity::class.java))
                } else {
                    Toast.makeText(
                        this@Register,
                        "Error ! " + task.exception!!.message,
                        Toast.LENGTH_SHORT
                    ).show()
                    progressBar!!.setVisibility(View.GONE)
                }
            }
        })
        mLoginBtn!!.setOnClickListener(View.OnClickListener {
            startActivity(
                Intent(
                    applicationContext,
                    Login::class.java
                )
            )
        })
    }

    companion object {
        const val TAG = "TAG"
    }
}
