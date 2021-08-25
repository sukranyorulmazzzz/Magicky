package com.example.recyclerview.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.TextView
import com.example.recyclerview.R
import com.example.recyclerview.SongData
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.item.*
import java.util.ArrayList


import com.google.android.material.bottomsheet.BottomSheetDialog;
import android.view.View;
import android.view.ViewGroup;

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
    lateinit var playPauseBtn:ImageView
    lateinit var seekBar: SeekBar
    lateinit var newActivity: NewActivity
    var listSongs = ArrayList<SongData?>()

    var position:Int=-1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_song)


        playPauseBtn=findViewById(R.id.play_pause)




        playPauseBtn.setOnClickListener{
            val view:View = layoutInflater.inflate(R.layout.item_bottom_sheet,null)
            val dialog= BottomSheetDialog(this)
            dialog.setContentView(view)
            dialog.show()
        }
        val bundle = intent.extras
       // val fetchData = bundle!!.getSerializable("key") as SongData?




    }


}