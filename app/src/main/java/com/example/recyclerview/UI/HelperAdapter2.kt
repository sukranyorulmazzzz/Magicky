package com.example.recyclerview.UI
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.R
import java.util.ArrayList
import com.google.firebase.database.DatabaseReference
import android.content.Intent
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_favourite.view.*


class HelperAdapter2(var fetchData: ArrayList<Song>) : RecyclerView.Adapter<RecyclerView.ViewHolder?>() {


    lateinit var favouriteList: ArrayList<String>

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
        viewHolderClass.itemView.setOnClickListener { view ->
            val intent = Intent(view.context, SongActivity::class.java)
            val bundle = Bundle()
             view.context.startActivity(intent)
        }
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

                imagebutton.setImageResource(R.drawable.ic_favorite_red_24dp)

                favouriteList = java.util.ArrayList()
                var database = FirebaseDatabase.getInstance()
                var myRef = database.getReference("Favorite")
                //favouriteList.add(fetchData[position].songName)
                var id=myRef.push()
                id.child("id").setValue(id.key.toString())
                id.child("songName").setValue(fetchData[position].songName)

                imagebutton.setOnClickListener {
                    Toast.makeText(it.context,
                        "You already liked..",
                        Toast.LENGTH_SHORT
                    ).show()
                      }
            }
            }
            }
            }




