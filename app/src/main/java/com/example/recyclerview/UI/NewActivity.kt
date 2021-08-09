package com.example.recyclerview.UI

import android.content.Intent
import com.example.recyclerview.R


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.Adapter.HelperAdapter2
import com.example.recyclerview.SongData
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_new.*
import kotlinx.android.synthetic.main.activity_new.view.*
import java.util.ArrayList

class NewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        var helperAdapter2: HelperAdapter2? = null
        var recyclerViewsSecond: RecyclerView? = null

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new)

        recyclerViewsSecond = findViewById(R.id.recyclerViewSecond)
        val intent = this.intent
        val bundle = intent.extras
        val name:TextView
        val info:TextView
        val img:ImageView
        val fetchData = bundle!!.getSerializable("key") as SongData?
        recyclerViewsSecond!!.setLayoutManager(LinearLayoutManager(this))
        val arrayList = ArrayList<String?>()

        name=findViewById(R.id.name)
        info=findViewById(R.id.info)

        img=findViewById(R.id.img)
        arrayList.add(fetchData!!.songName)
        arrayList.add(fetchData!!.songName2)
        arrayList.add(fetchData!!.songName3)
        arrayList.add(fetchData!!.songName4)
        arrayList.add(fetchData!!.songName5)
        arrayList.add(fetchData!!.songName6)
        arrayList.add(fetchData!!.songName7)
        arrayList.add(fetchData!!.songName8)
        arrayList.add(fetchData!!.songName9)
        arrayList.add(fetchData!!.songName91)
        name.text=fetchData.name
        info.text=fetchData.info


        Picasso.get().load(fetchData.img).into(img)

        helperAdapter2 = HelperAdapter2(arrayList)
        recyclerViewsSecond!!.setAdapter(helperAdapter2)


    }
}

