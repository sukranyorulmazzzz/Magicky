package com.example.recyclerview.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import com.example.recyclerview.R
import com.example.recyclerview.databinding.ActivityProfileBinding
import com.google.firebase.auth.FirebaseAuth

class ProfileActivity : AppCompatActivity() {

    private lateinit var binding:ActivityProfileBinding
    private lateinit var actionBar: ActionBar
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityProfileBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

       // actionBar=supportActionBar!!
        //actionBar.title="Profile"

        firebaseAuth= FirebaseAuth.getInstance()
        checkUser()

        binding.logutBtn.setOnClickListener {
            firebaseAuth.signOut()
            checkUser()
        }
    }

    private fun checkUser() {
        val firebaseUser=firebaseAuth.currentUser
        if (firebaseUser!=null){

            val email=firebaseUser.email
            binding.emailTv.text=email
        }
        else{
            startActivity(Intent(this,LoginActivity::class.java))
            finish()
        }
    }
}