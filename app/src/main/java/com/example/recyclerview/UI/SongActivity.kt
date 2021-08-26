package com.example.recyclerview.UI

import android.content.Intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.SparseArray
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.TextView
import com.example.recyclerview.R
import com.example.recyclerview.SongData
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.item.*


import com.google.android.material.bottomsheet.BottomSheetDialog;
import android.view.View;
import android.view.ViewGroup;
import at.huber.youtubeExtractor.VideoMeta
import at.huber.youtubeExtractor.YouTubeExtractor
import at.huber.youtubeExtractor.YtFile
import com.google.android.exoplayer2.MediaItem

import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.MergingMediaSource
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.upstream.DefaultHttpDataSource
import com.google.android.exoplayer2.util.Util
import com.google.android.exoplayer2.util.Util.SDK_INT
import kotlinx.android.synthetic.main.activity_song.*

class SongActivity : AppCompatActivity() {

    private var player:SimpleExoPlayer?=null
    private var playWhenReady=true
    private var currentWindow=0
    private var playbackPosition:Long=0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_song)
        initPlayer()
    }

    private fun initPlayer() {
        player=SimpleExoPlayer.Builder(this).build()
        video_view.player=player
        val videoUrl="https://www.youtube.com/watch?v=o_1aF54DO60&ab_channel=LanaDelReyVEVO"
        object:YouTubeExtractor(this){
            override fun onExtractionComplete(
                ytFiles: SparseArray<YtFile>?,
                videoMeta: VideoMeta?
            ) {
                if(ytFiles!=null){
                    val itag=137
                    val audiotag=140
                    val videoUrl=ytFiles[itag].url
                    val audioUrl=ytFiles[audiotag].url
                    val audioSource:MediaSource=ProgressiveMediaSource
                        .Factory(DefaultHttpDataSource.Factory())
                        .createMediaSource(MediaItem.fromUri(audioUrl))
                    val videoSource:MediaSource=ProgressiveMediaSource
                        .Factory(DefaultHttpDataSource.Factory())
                        .createMediaSource(MediaItem.fromUri(videoUrl))

                    player!!.setMediaSource(MergingMediaSource(
                        true,videoSource,audioSource
                    ),true)
                    player!!.prepare()
                    player!!.playWhenReady=playWhenReady
                    player!!.seekTo(currentWindow,playbackPosition)

                }
            }

        }.extract(videoUrl,false,true)
    }

    override fun onStart() {
        super.onStart()
        if(Util.SDK_INT>=24)
            initPlayer()
    }

    override fun onResume() {
        super.onResume()
        if (Util.SDK_INT<24||player==null){
            initPlayer()
            hideSystemUi()
        }
    }

    private fun hideSystemUi() {
        video_view.systemUiVisibility=(
                View.SYSTEM_UI_FLAG_LOW_PROFILE or
                        View.SYSTEM_UI_FLAG_FULLSCREEN or
                        View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
                        View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY or
                        View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or
                        View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                )
    }

    override fun onPause() {
        if(Util.SDK_INT<24) releasePlayer()
        super.onPause()

    }

    override fun onStop() {
        if(Util.SDK_INT<24) releasePlayer()
        super.onStop()
    }

    private fun releasePlayer() {
        if(player!=null){
            playWhenReady=player!!.playWhenReady
            playbackPosition=player!!.currentPosition
            currentWindow=player!!.currentWindowIndex
            player!!.release()
            player=null
        }
    }
}