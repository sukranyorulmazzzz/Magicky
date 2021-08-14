package com.example.recyclerview.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.TextView
import com.example.recyclerview.R
import com.example.recyclerview.SongData
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.util.ArrayList

class SongActivity : AppCompatActivity() {

    lateinit var songName:TextView
    lateinit var duration_played:TextView
    lateinit var duration_total:TextView
    lateinit var cover_art:ImageView
    lateinit var nextBtn:ImageView
    lateinit var prevBtn:ImageView
    lateinit var backBtn:ImageView
    lateinit var shuffleBtn:ImageView
    lateinit var repeatBtn:ImageView
    lateinit var playPauseBtn:FloatingActionButton
    lateinit var seekBar: SeekBar
    var listSongs = ArrayList<SongData?>()

    var position:Int=-1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_song)

        songName=findViewById(R.id.song_name)
        duration_played=findViewById(R.id.durationPlayed)
        duration_total=findViewById(R.id.durationTotal)
        cover_art=findViewById(R.id.cover_art)
        nextBtn=findViewById(R.id.ic_next)
        prevBtn=findViewById(R.id.ic_prev)
        backBtn=findViewById(R.id.back_btn)
        shuffleBtn=findViewById(R.id.ic_shuffle)
        repeatBtn=findViewById(R.id.ic_repeat)
        playPauseBtn=findViewById(R.id.play_pause)
        seekBar=findViewById(R.id.seekBar)



        playPauseBtn.setOnClickListener{
            playPauseBtn.setImageResource(R.drawable.ic_baseline_pause_24)
            playPauseBtn.setOnClickListener{
                playPauseBtn.setImageResource(R.drawable.ic_baseline_play_arrow_24)
            }
        }



    }


}