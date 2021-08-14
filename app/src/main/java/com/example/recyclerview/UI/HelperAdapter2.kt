package com.example.recyclerview.UI
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.R
import java.util.ArrayList

class HelperAdapter2(var fetchData: ArrayList<String?>) : RecyclerView.Adapter<RecyclerView.ViewHolder?>() {

private lateinit var mListener:onItemClickListener
interface onItemClickListener{
    fun onItemClick(position: Int)
}
    fun setOnItemClickListener(listener:onItemClickListener){
        mListener=listener
    }

    var subitemListFinal = ArrayList<String>()
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return ViewHolderClass(view,mListener)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewHolderClass = holder as ViewHolderClass
        val fetchDatalist = fetchData[position]
        viewHolderClass.textView.text = fetchDatalist
    }

    override fun getItemCount(): Int {
        return fetchData.size
    }


    inner class ViewHolderClass(itemView: View,listener:onItemClickListener) : RecyclerView.ViewHolder(itemView) {
        var textView: TextView

        init {
            textView = itemView.findViewById(R.id.maintextView)
            itemView.setOnClickListener{
                listener.onItemClick(adapterPosition)
            }
            }
            }
        }



