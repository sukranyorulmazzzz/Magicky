package com.example.recyclerview.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.Model.Pop
import com.example.recyclerview.R

class PopAdapter(private val popList:ArrayList<Pop>): RecyclerView.Adapter<PopAdapter.MyNewViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyNewViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.row,parent,false)
        return MyNewViewHolder(view)



            }

    override fun onBindViewHolder(holder: MyNewViewHolder, position: Int) {

        val currentItem=popList[position]
        holder.titleimage.setImageResource(currentItem.titleimage)
        holder.tvHeading.text=currentItem.heading


    }



    override fun getItemCount(): Int {
       return popList.size
    }
    class MyNewViewHolder(itemview : View): RecyclerView.ViewHolder(itemview) {

        val titleimage: ImageView =itemview.findViewById(R.id.title_image)
        val tvHeading:TextView=itemview.findViewById(R.id.tvHeading)

    }
}