package com.example.recyclerview.UI

import android.content.Intent
import com.example.recyclerview.R


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_new.*

class NewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        var backtBtn: Button? = null
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new)

        backtBtn=findViewById(R.id.buttonback)

        buttonback.setOnClickListener{
            val intent =Intent(this,HomeYeni::class.java)

            startActivity(intent)
        }
        /**get Data*/
        val animalIntent = intent
        val animalName = animalIntent.getStringExtra("name")
        val animalInfo = animalIntent.getStringExtra("info")
        val animalImg = animalIntent.getStringExtra("img")

        /**call text and images*/
        name.text = animalName
        info.text = animalInfo
        img.loadImage(animalImg, getProgessDrawable(this))
    }
    /**ok now run it */
}