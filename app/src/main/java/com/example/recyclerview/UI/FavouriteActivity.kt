package com.example.recyclerview.UI

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.R
import com.example.recyclerview.Adapter.CustomAdapter
import io.realm.Realm
import io.realm.RealmChangeListener

class FavouriteActivity : AppCompatActivity() {

    var realm: Realm? = null
    var rv: RecyclerView? = null
    var helper: MyHelper? = null
    var realmChangeListener: RealmChangeListener<*>? = null
    var backbutton: Button?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favourite)

        backbutton=findViewById(R.id.back_btn2)
        backbutton!!.setOnClickListener {
            val intent= Intent(this,MainActivity::class.java)
            startActivity(intent)

        }
        rv = findViewById(R.id.recyclerviewfavourite)

        Realm.init(this)


        realm = Realm.getDefaultInstance()
        helper = MyHelper(realm)
        helper!!.selectFromDB()
        val adapter = CustomAdapter(this, helper!!.justRefresh())
        rv!!.setLayoutManager(LinearLayoutManager(this))
        rv!!.setAdapter(adapter)
        refresh()
    }

    private fun refresh() {
        realmChangeListener = RealmChangeListener<Any?> {
            val adapter = CustomAdapter(this, helper!!.justRefresh())
            rv!!.adapter = adapter
        }
        realm!!.addChangeListener(realmChangeListener as RealmChangeListener<Realm>)
    }

    override fun onDestroy() {
        super.onDestroy()
        realm!!.removeChangeListener(realmChangeListener as RealmChangeListener<Realm>)
        realm!!.close()
    }


}
