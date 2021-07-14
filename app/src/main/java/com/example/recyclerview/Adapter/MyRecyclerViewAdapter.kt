package com.example.recyclerview.Adapter

import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.Model.Tasks
import com.example.recyclerview.Adapter.MyRecyclerViewAdapter.MyViewHolder
import com.example.recyclerview.UI.MainActivity
import com.example.recyclerview.R
import com.example.recyclerview.UI.RealMHelper
import com.google.firebase.database.FirebaseDatabase
import io.realm.OrderedRealmCollection
import io.realm.RealmRecyclerViewAdapter
import java.util.*

class MyRecyclerViewAdapter(data: OrderedRealmCollection<Tasks?>) :
    RealmRecyclerViewAdapter<Tasks?, MyViewHolder>(
        data, true
    ) {
    var mainActivity: MainActivity? = null
    private val db = FirebaseDatabase.getInstance()
    private val root = db.reference
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_layout, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val tasks = getItem(position)
        holder.idTV.text = java.lang.String.valueOf(tasks!!.task_id)
        holder.tasknameTV.text = tasks.task_name
        holder.icondelete.setOnClickListener { v ->
            val builder = AlertDialog.Builder(v.rootView.context)

            //ayrı bi classa ekle

            val dialogview =
                LayoutInflater.from(v.rootView.context).inflate(R.layout.custom_dialog, null)
            builder.setView(dialogview)
            builder.setCancelable(true)
            builder.setNegativeButton("Cancel", null)
            builder.setPositiveButton("Delete") { dialogInterface, i ->
                val helper = RealMHelper()
                data?.get(position)?.let { helper.deleteData(it.task_id) }
            }
            builder.show()
        }
        holder.like.setOnClickListener { v ->
            val userMap = HashMap<String, String?>()
            userMap["Tasks"] = tasks.task_name
            root.push().setValue(userMap)
            Toast.makeText(v.context, "Data saved succesfully...", Toast.LENGTH_LONG).show()
        }
    }

    override fun getItemId(position: Int): Long {
        return getItem(position)!!.task_id.toLong()
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var idTV: TextView
        var tasknameTV: TextView
        var like: Button
        var icondelete: Button

        init {
            idTV = itemView.findViewById(R.id.idTV)
            tasknameTV = itemView.findViewById(R.id.tasknameTV)
            like = itemView.findViewById(R.id.like)
            icondelete = itemView.findViewById(R.id.icondelete)
        }
    }
}