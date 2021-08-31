package com.example.recyclerview.UI

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.R
import com.example.recyclerview.UI.CustomAdapter
import com.example.recyclerview.UI.MyHelper
import io.realm.Realm
import io.realm.RealmChangeListener

class FavouriteActivity : AppCompatActivity() {

    var realm: Realm? = null
    var rv: RecyclerView? = null
    var helper: MyHelper? = null
    var realmChangeListener: RealmChangeListener<*>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favourite)

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
