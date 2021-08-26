package com.example.recyclerview.UI

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.recyclerview.R
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth


class Login : AppCompatActivity() {
    lateinit var sharedPreferences: SharedPreferences
    var isRemembered=false
    var mEmail: EditText? = null
    var mPassword: EditText? = null
    var mLoginBtn: Button? = null
    var checkboxx: CheckBox? = null
    var mCreateBtn: TextView? = null
    var forgotTextLink: TextView? = null
    var progressBar: ProgressBar? = null
    var fAuth: FirebaseAuth? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        mEmail = findViewById(R.id.Email)
        mPassword = findViewById(R.id.password)
        progressBar = findViewById(R.id.progressBar)
        fAuth = FirebaseAuth.getInstance()
        mLoginBtn = findViewById(R.id.loginBtn)
        mCreateBtn = findViewById(R.id.createText)
        forgotTextLink = findViewById(R.id.forgotPassword)
        checkboxx=findViewById(R.id.checkBox)


        sharedPreferences=getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)
        isRemembered=sharedPreferences.getBoolean("CHECKBOX",false)
        if (isRemembered){
            val intent=Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        mLoginBtn!!.setOnClickListener(View.OnClickListener {
            val email = mEmail!!.getText().toString().trim { it <= ' ' }
            val password = mPassword!!.getText().toString().trim { it <= ' ' }
            val checked:Boolean=checkboxx!!.isChecked
            val editor:SharedPreferences.Editor=sharedPreferences.edit()
            editor.putString("EMAIL",email)
            editor.putString("PASSWORD",password)
            editor.putBoolean("CHECKBOX",checked)
            editor.apply()
            Toast.makeText(this,"Information Saved",Toast.LENGTH_LONG).show()

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

            // authenticate the user
            fAuth!!.signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Toast.makeText(this@Login, "Logged in Successfully", Toast.LENGTH_SHORT)
                        .show()
                    startActivity(Intent(applicationContext, MainActivity::class.java))
                } else {
                    Toast.makeText(
                        this@Login,
                        "Error ! " + task.exception!!.message,
                        Toast.LENGTH_SHORT
                    ).show()
                    progressBar!!.setVisibility(View.GONE)
                }
            }
        })
        mCreateBtn!!.setOnClickListener(View.OnClickListener {
            startActivity(
                Intent(
                    applicationContext,
                    Register::class.java
                )
            )
        })
        forgotTextLink!!.setOnClickListener(View.OnClickListener { v ->
            val resetMail = EditText(v.context)
            val passwordResetDialog = AlertDialog.Builder(v.context)
            passwordResetDialog.setTitle("Reset Password ?")
            passwordResetDialog.setMessage("Enter Your Email To Received Reset Link.")
            passwordResetDialog.setView(resetMail)
            passwordResetDialog.setPositiveButton(
                "Yes"
            ) { dialog, which -> // extract the email and send reset link
                val mail = resetMail.text.toString()
                fAuth!!.sendPasswordResetEmail(mail).addOnSuccessListener {
                    Toast.makeText(
                        this@Login,
                        "Reset Link Sent To Your Email.",
                        Toast.LENGTH_SHORT
                    ).show()
                }.addOnFailureListener { e ->
                    Toast.makeText(
                        this@Login,
                        "Error ! Reset Link is Not Sent" + e.message,
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
            passwordResetDialog.setNegativeButton(
                "No"
            ) { dialog, which ->
                // close the dialog
            }
            passwordResetDialog.create().show()
        })
    }
}
