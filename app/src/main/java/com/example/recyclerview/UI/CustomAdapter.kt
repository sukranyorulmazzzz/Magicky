package com.example.recyclerview.UI

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import android.view.LayoutInflater
import com.example.recyclerview.R
import com.example.recyclerview.Song
import java.util.ArrayList

class CustomAdapter(var c: Context, var song: ArrayList<Song>) :
    RecyclerView.Adapter<MyViewHolderFavourite>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolderFavourite {
        val view = LayoutInflater.from(c).inflate(R.layout.itemfavourite, parent, false)
        return MyViewHolderFavourite(view)
    }

    override fun onBindViewHolder(holderFavourite: MyViewHolderFavourite, position: Int) {
        val s = song[position]
        holderFavourite.mainTextView.text = s.getsongName()
    }

    override fun getItemCount(): Int {
        return song.size
    }
}