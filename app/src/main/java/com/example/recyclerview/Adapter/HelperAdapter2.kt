package com.example.recyclerview.Adapter
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
import android.content.Intent
import android.util.Log
import com.example.recyclerview.Song
import com.example.recyclerview.UI.MyApplication
import com.example.recyclerview.UI.MyHelper
import com.example.recyclerview.UI.NewActivity
import com.example.recyclerview.UI.SongActivity
import com.google.firebase.database.FirebaseDatabase
import io.realm.Realm
import io.realm.Realm.getApplicationContext
import io.realm.RealmChangeListener


class HelperAdapter2(var fetchData: ArrayList<Song>) : RecyclerView.Adapter<RecyclerView.ViewHolder?>() {

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


        var realm: Realm? = null
        var helper: MyHelper? = null
        var realmChangeListener: RealmChangeListener<*>? = null

        init {
            textView = itemView.findViewById(R.id.maintextView)
            imagebutton=itemView.findViewById(R.id.likebutton)

            Realm.init(itemView.context)
            realm = Realm.getDefaultInstance()



            imagebutton.setOnClickListener{


                realm!!.executeTransactionAsync({ realm ->
                     val song = realm.createObject(Song::class.java)
                    song.setsongName(fetchData[position].songName)
                }, {   imagebutton.setImageResource(R.drawable.ic_favorite_red_24dp)

                    Toast.makeText(itemView.context, "Success", Toast.LENGTH_LONG).show()
                }
                )
                {Toast.makeText(itemView.context, "Fail", Toast.LENGTH_LONG).show()
                }
              }}


    }



}

