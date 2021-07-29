package com.example.recyclerview.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.Model.CategoryItem
import com.example.recyclerview.R
import com.example.recyclerview.UI.SongDetails

class CategoryItemRecyclerAdapter(
    private val context: Context,
    private val categoryItemList: List<CategoryItem>
) : RecyclerView.Adapter<CategoryItemRecyclerAdapter.CategoryItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryItemViewHolder {
        return CategoryItemViewHolder(
            LayoutInflater.from(context).inflate(R.layout.cat_row_items, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CategoryItemViewHolder, position: Int) {
        holder.itemImage.setImageResource(categoryItemList[position].imageUrl)
        holder.itemImage.setOnClickListener {
            val i = Intent(context, SongDetails::class.java)
            i.putExtra("songImage", categoryItemList[position].imageUrl)
            i.putExtra("songId", categoryItemList[position].itemId)
            i.putExtra("songName", categoryItemList[position].songName)
            i.putExtra("songExplanation", categoryItemList[position].songExplanation)
            context.startActivity(i)
        }
    }

    override fun getItemCount(): Int {
        return categoryItemList.size
    }

    class CategoryItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemImage: ImageView

        init {
            itemImage = itemView.findViewById(R.id.item_image)
        }
    }
}