package com.example.recyclerview.UI

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.Adapter.MyRecyclerViewAdapter
import com.example.recyclerview.Model.Tasks
import com.example.recyclerview.Model.VariableHolder
import com.example.recyclerview.R
import io.realm.OrderedRealmCollection
import io.realm.Realm
import io.realm.RealmConfiguration

class MainActivity : AppCompatActivity() {
    var data: OrderedRealmCollection<Tasks>? = null
    var taskName: EditText? = null
    var insertBtn: Button? = null
    var rv: RecyclerView? = null
    var tvEmpty: TextView? = null
    var relativeLayout: RelativeLayout? = null
    var adapter: MyRecyclerViewAdapter? = null
    var helper: RealMHelper? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Realm.init(applicationContext)
        val config = RealmConfiguration.Builder()
            .allowQueriesOnUiThread(true)
            .allowWritesOnUiThread(true)
            .build()
        realm = Realm.getInstance(config)
        helper = RealMHelper()
        taskName = findViewById(R.id.taskName)
        VariableHolder.taskName = taskName
        insertBtn = findViewById(R.id.insertBtn)
        tvEmpty = findViewById(R.id.tv_empty)
        relativeLayout = findViewById(R.id.relativelayout)
        rv = findViewById(R.id.rv)
        updateRV()
        insertBtn?.setOnClickListener(View.OnClickListener {
            val task_name = taskName?.getText().toString()
            helper!!.insertData(Tasks(task_name))
            taskName?.setText("")
            updateRV()
            Toast.makeText(this@MainActivity, "Data saved succesfully...", Toast.LENGTH_SHORT)
                .show()
        })
    }

    fun updateRV() {
        adapter = MyRecyclerViewAdapter(helper!!.data as OrderedRealmCollection<Tasks?>)
        rv!!.layoutManager = LinearLayoutManager(this)
        rv!!.adapter = adapter
    }

    companion object {
        var realm: Realm? = null
    }
}