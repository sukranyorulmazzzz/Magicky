package com.example.recyclerview.UI

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.recyclerview.R

class MovieDetails : AppCompatActivity() {
    var songImage: ImageView? = null
    var songName: TextView? = null
    var mImage: String? = null
    var mId: String? = null
    var mName: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)
        songImage = findViewById(R.id.song_image)
        songName = findViewById(R.id.song_name)
        mId = intent.getStringExtra("songId")
        mImage = intent.getStringExtra("songImage")
        mName = intent.getStringExtra("songName")
        songName!!.setText(mName)
    }
}