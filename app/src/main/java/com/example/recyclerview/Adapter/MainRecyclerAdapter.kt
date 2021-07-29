package com.example.recyclerview.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.Model.AllCategory
import com.example.recyclerview.Model.CategoryItem
import com.example.recyclerview.R
import com.example.recyclerview.UI.SongDetails


class MainRecyclerAdapter(
    private val context: Context,
    private val allCategoryList: List<AllCategory>
) : RecyclerView.Adapter<MainRecyclerAdapter.MainViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(
            LayoutInflater.from(context).inflate(R.layout.main_recycler_row_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.categoryTitle.text = allCategoryList[position].categoryTitle
        setCatItemRecycler(holder.itemRecycler, allCategoryList[position].categoryItemList)
        holder.itemView.setOnClickListener {
            val i = Intent(context, SongDetails::class.java)
            i.putExtra("songName", allCategoryList[position].categoryTitle)
            i.putExtra("songExplanation", allCategoryList[position].categoryExplanation)
            context.startActivity(i)
        }
    }

    override fun getItemCount(): Int {
        return allCategoryList.size
    }

    class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var categoryTitle: TextView
        var itemRecycler: RecyclerView

        init {
            categoryTitle = itemView.findViewById(R.id.cat_title)
            itemRecycler = itemView.findViewById(R.id.item_recycler)
        }
    }

    private fun setCatItemRecycler(
        recyclerView: RecyclerView,
        categoryItemList: List<CategoryItem>
    ) {
        val itemRecyclerAdapter = CategoryItemRecyclerAdapter(
            context, categoryItemList
        )
        recyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        recyclerView.adapter = itemRecyclerAdapter
    }
}