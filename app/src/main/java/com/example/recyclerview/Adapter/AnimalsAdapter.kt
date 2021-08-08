package com.example.recyclerview.UI
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recyclerview.SongData

import com.example.recyclerview.R
import com.squareup.picasso.Picasso

class AnimalsAdapter(var songData: List<SongData>) : RecyclerView.Adapter<RecyclerView.ViewHolder?>() {
    var context: Context? = null
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return ViewHolderClass(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewHolderClass = holder as ViewHolderClass
        val fetchDatalist = songData[position]
        viewHolderClass.textView.text = fetchDatalist.name
        viewHolderClass.textView2.text = fetchDatalist.info

        Picasso.get().load(fetchDatalist.img).into(viewHolderClass.imageview)
         viewHolderClass.itemView.setOnClickListener { view ->
            val intent = Intent(view.context, NewActivity::class.java)
            val bundle = Bundle()
            bundle.putSerializable("key", fetchDatalist)
            intent.putExtras(bundle)
            view.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return songData.size
    }

    inner class ViewHolderClass(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textView: TextView
        var textView2: TextView
        var imageview: ImageView

        init {
            textView = itemView.findViewById(R.id.animalName)
            textView2 = itemView.findViewById(R.id.animalInfo)
            imageview = itemView.findViewById(R.id.animalImg)
            }
    }
}