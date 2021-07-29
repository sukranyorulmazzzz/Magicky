package com.example.recyclerview.UI

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.recyclerview.R

class SongDetails : AppCompatActivity() {
    var songImage: ImageView? = null
    var songName: TextView? = null
    var songExplanation: TextView? = null
    var mImage: String? = null
    var mId: String? = null
    var mName: String? = null
    var mExplanation: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_song_details)
        songImage = findViewById(R.id.song_image)
        songName = findViewById(R.id.song_name)
        songExplanation = findViewById(R.id.song_explanation)
        mId = intent.getStringExtra("songId")
        mImage = intent.getStringExtra("songImage")
        mName = intent.getStringExtra("songName")
        mExplanation = intent.getStringExtra("songExplanation")
        songName!!.setText(mName)
        songExplanation!!.setText(mExplanation)

           }
}