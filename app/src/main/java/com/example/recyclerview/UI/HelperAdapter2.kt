package com.example.recyclerview.UI
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.R
import java.util.ArrayList
import com.google.firebase.database.DatabaseReference

import com.google.firebase.database.FirebaseDatabase




class HelperAdapter2(var fetchData: ArrayList<Song>) : RecyclerView.Adapter<RecyclerView.ViewHolder?>() {



    var subitemListFinal = ArrayList<String>()
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return ViewHolderClass(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewHolderClass = holder as ViewHolderClass
        val fetchDatalist = fetchData[position]
        viewHolderClass.textView.text = fetchDatalist.songName
    }

    override fun getItemCount(): Int {
        return fetchData.size
    }


    inner class ViewHolderClass(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textView: TextView
        var imagebutton:ImageButton


        init {
            textView = itemView.findViewById(R.id.maintextView)
            imagebutton=itemView.findViewById(R.id.likebutton)


            imagebutton.setOnClickListener{

            }
            }
            }
        }



