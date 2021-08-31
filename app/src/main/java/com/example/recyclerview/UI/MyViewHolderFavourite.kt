package com.example.recyclerview.UI

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import android.widget.TextView
import com.example.recyclerview.R

class MyViewHolderFavourite(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var mainTextView: TextView

    init {
        mainTextView = itemView.findViewById(R.id.maintextView)
    }
}