package com.example.recyclerview.UI

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.Adapter.PopAdapter
import com.example.recyclerview.Model.Pop
import com.example.recyclerview.R

class Home: AppCompatActivity() {

    private lateinit var recyclerview:RecyclerView
    var recyclerview2:RecyclerView?=null
    var recyclerview3:RecyclerView?=null
    private lateinit var adapterpop:PopAdapter
    private lateinit var newArrayList: ArrayList<Pop>
    lateinit var imageId:Array<Int>
    var image: ImageView? = null

    lateinit var heading:Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home)
        imageId= arrayOf(
            R.drawable.home,
            R.drawable.school,
            R.drawable.ulasim,
            R.drawable.clothing,
            R.drawable.food,
            R.drawable.sleep,
            R.drawable.workout,
            R.drawable.hobbies,
            R.drawable.films,
            R.drawable.books,
            R.drawable.music
        )

        heading= arrayOf(
            "Chores",
            "School",
            "Transportation",
            "Clothing",
            "Food Recipes",
            "Before Sleeping",
            "Workout",
            "Hobbies",
            "Films",
            "Books",
            "Music"
        )



        recyclerview=findViewById(R.id.recyclerview)

        recyclerview.layoutManager=LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)

        recyclerview.setHasFixedSize(true)
        newArrayList= arrayListOf<Pop>()
        getUserData()
        recyclerview=findViewById(R.id.recyclerview)






    }



    public fun getUserData() {
        for(i in imageId.indices){
             val news= Pop(imageId[i],heading[i])
            newArrayList.add(news)

        }
        recyclerview.adapter= PopAdapter(newArrayList)
    }


}