package com.example.recyclerview.UI
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.SongData

import com.example.recyclerview.R
import com.example.recyclerview.databinding.ItemListBinding

class AnimalsAdapter(
    var c:Context,
    var songList:ArrayList<SongData>
):RecyclerView.Adapter<AnimalsAdapter.AnimalViewHolder>()
{
    inner class AnimalViewHolder(var v: ItemListBinding): RecyclerView.ViewHolder(v.root){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        val inflter = LayoutInflater.from(parent.context)
        val v = DataBindingUtil.inflate<ItemListBinding>(
            inflter, R.layout.item_list,parent,
            false)
        return AnimalViewHolder(v)

    }


    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        val newList = songList[position]
        holder.v.isAnimals = songList[position]
        holder.v.root.setOnClickListener {
            val img = newList.img
            val name = newList.name
            val info = newList.info

            /**set Data*/
            val mIntent = Intent(c,NewActivity::class.java)
            mIntent.putExtra("img",img)
            mIntent.putExtra("name",name)
            mIntent.putExtra("info",info)
            c.startActivity(mIntent)
        }
    }


    override fun getItemCount(): Int {
        return  songList.size
    }




}