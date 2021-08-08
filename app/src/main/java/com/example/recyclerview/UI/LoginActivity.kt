package com.example.recyclerview.UI

import android.app.ActionBar
import android.app.ProgressDialog
import android.content.Intent

import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import com.example.recyclerview.R
import com.example.recyclerview.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth
import java.util.regex.Pattern

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
   // private lateinit var actionBar: ActionBar
    private lateinit var progressDialog: ProgressDialog
    private lateinit var firebaseAuth: FirebaseAuth
    private var email=""
    private var password=""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

       // actionBar=supportActionBar!!
        //actionBar.title="Login"
        progressDialog= ProgressDialog(this)
        progressDialog.setTitle("Please wait")
        progressDialog.setMessage("Logging in...")
        progressDialog.setCanceledOnTouchOutside(false)

        firebaseAuth= FirebaseAuth.getInstance()
        checkUser()

        binding.noAccountTv.setOnClickListener{
            startActivity(Intent(this,SignUpActivity::class.java))
        }
        binding.loginBtn.setOnClickListener{
            validateData()
        }
    }

    private fun validateData() {

        email=binding.emailEt.text.toString().trim()
        password=binding.passwordEt.text.toString().trim()

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            binding.emailEt.setError("invalid email format")
        }
        else if(TextUtils.isEmpty(password)){
            binding.passwordEt.setError("please enter password")
        }
        else{
            firebaseLogin()
        }

    }

    private fun firebaseLogin() {
        progressDialog.show()
        firebaseAuth.signInWithEmailAndPassword(email,password)
            .addOnSuccessListener {
            //basarılı giris
                progressDialog.dismiss()
                val firebaseUser=firebaseAuth.currentUser
                val email=firebaseUser!!.email
                Toast.makeText(this,"Logged in as $email  ",Toast.LENGTH_SHORT).show()
                startActivity(Intent(this,HomeYeni::class.java))
                finish()
            }
            .addOnFailureListener{
           //basarısız giris
                progressDialog.dismiss()
                Toast.makeText(this,"Login failed ",Toast.LENGTH_SHORT).show()
            }
    }

    private fun checkUser() {
        val firebaseUser=firebaseAuth.currentUser
        if (firebaseUser!=null){
            startActivity(Intent(this,HomeYeni::class.java))
        }
    }
}