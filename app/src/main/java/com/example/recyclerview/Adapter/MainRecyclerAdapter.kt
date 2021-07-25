package com.example.recyclerview.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.Model.AllCategory
import com.example.recyclerview.Model.CategoryItem
import com.example.recyclerview.R


class MainRecyclerAdapter(private val context: Context, private val allCategory:List<AllCategory>):
    RecyclerView.Adapter<MainRecyclerAdapter.MainViewHolder>(){

    private lateinit var mListener: onItemClickListener
    interface onItemClickListener{
        fun onItemClick(position: Int)
    }
    fun setOnItemClickListener(listener:onItemClickListener){
        mListener=listener

    }

    class MainViewHolder(itemView: View,listener:onItemClickListener):RecyclerView.ViewHolder(itemView){

       var categoryTitle: TextView
       var itemRecycler:RecyclerView

        init{
            categoryTitle=itemView.findViewById(R.id.cat_title)
            itemRecycler=itemView.findViewById(R.id.item_recycler)
            itemView.setOnClickListener{
                listener.onItemClick(adapterPosition)
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType:Int):MainViewHolder{
        return MainViewHolder(LayoutInflater.from(context).inflate(R.layout.main_recycler_row_item,parent,false),mListener)
    }
    override fun getItemCount():Int{
      return allCategory.size
    }
    override fun onBindViewHolder(holder:MainViewHolder, position:Int){

        holder.categoryTitle.text=allCategory[position].categoryTitle
        setCatItemRecycler(holder.itemRecycler,allCategory[position].categoryItem)
    }

    private fun setCatItemRecycler(recyclerView: RecyclerView,categoryItem:List<CategoryItem>){
        val itemRecyclerAdapter=CategoryItemAdapter(context,categoryItem)
        recyclerView.layoutManager=LinearLayoutManager(context,RecyclerView.HORIZONTAL,false)
        recyclerView.adapter=itemRecyclerAdapter
    }
}

