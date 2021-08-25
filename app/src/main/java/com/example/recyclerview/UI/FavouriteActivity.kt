package com.example.recyclerview.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.R
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_favourite.*
import kotlinx.android.synthetic.main.activity_new.*

class FavouriteActivity : AppCompatActivity() {
    var recyclerView: RecyclerView? = null
    var helperAdapter2: HelperAdapter2? = null
    var databaseReference: DatabaseReference? = null
    lateinit var songData: java.util.ArrayList<Song>
    var backbutton: ImageView? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favourite)

        backbutton=findViewById(R.id.back_btn2)
        backbutton!!.setOnClickListener {
            val intent=Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

        recyclerView = findViewById(R.id.recyclerviewfavourite)
        recyclerView!!.setLayoutManager(
            LinearLayoutManager(
                this,
                LinearLayoutManager.VERTICAL,
                false
            )
        )
        songData = java.util.ArrayList()
        databaseReference = FirebaseDatabase.getInstance().getReference("Favorite")
        databaseReference!!.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (ds in dataSnapshot.children) {
                    val fetchDatalist = ds.getValue(Song::class.java)
                    if (fetchDatalist != null) {
                        songData!!.add(fetchDatalist)
                    }
                }
                helperAdapter2 = HelperAdapter2(songData!!)
                recyclerviewfavourite!!.setAdapter(helperAdapter2)
            }

            override fun onCancelled(databaseError: DatabaseError) {}
        })

    }
}