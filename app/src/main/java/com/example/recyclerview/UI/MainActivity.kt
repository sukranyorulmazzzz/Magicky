package com.example.recyclerview.UI


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.models.SlideModel
import com.example.recyclerview.SongData
import com.example.recyclerview.R
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.google.firebase.auth.FirebaseAuth

import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_home_yeni.*
import java.util.*
import kotlin.collections.ArrayList


class MainActivity : AppCompatActivity() {


  var searchbutton:ImageView? = null

  var recyclerView: RecyclerView? = null
  var favouriteList:ImageView?= null
  var recyclerView2: RecyclerView? = null
  var recyclerView3: RecyclerView? = null
  var recyclerView4: RecyclerView? = null
  private lateinit var songData: java.util.ArrayList<SongData>
  private lateinit var songData2: java.util.ArrayList<SongData>
  private lateinit var songData3: java.util.ArrayList<SongData>
  private lateinit var songData4: java.util.ArrayList<SongData>
  var animalsAdapter: AnimalsAdapter<Any?, Any?>? = null
  var animalsAdapter2: AnimalsAdapter<Any?, Any?>? = null
  var animalsAdapter3: AnimalsAdapter<Any?, Any?>? = null
  var animalsAdapter4: AnimalsAdapter<Any?, Any?>? = null
  var databaseReference: DatabaseReference? = null
  var databaseReference2: DatabaseReference? = null
  var databaseReference3: DatabaseReference? = null
  var databaseReference4: DatabaseReference? = null


  val imageList = java.util.ArrayList<SlideModel>()
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_home_yeni)


    favouriteList=findViewById(R.id.favouriteList)
    searchbutton=findViewById(R.id.searchbutton)

    favouriteList!!.setOnClickListener {
      val intent=Intent(this,FavouriteActivity::class.java)
      startActivity(intent)
    }
    searchbutton!!.setOnClickListener {
      val intent=Intent(this,SearchActivity::class.java)
      startActivity(intent)
    }

    imageview_options.setOnClickListener {
      val popupMenu = PopupMenu(this, it)
      popupMenu.setOnMenuItemClickListener { item ->
        when (item.itemId) {
          R.id.menu_home -> {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            true
          }
          R.id.menu_profile -> {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
            true
          }
          R.id.menu_settings -> {
            FirebaseAuth.getInstance().signOut() //logout
            startActivity(Intent(applicationContext, Login::class.java))
            finish()
            true
          }

          else -> false
        }
      }
      popupMenu.inflate(R.menu.iconmenu)
      popupMenu.show()
    }


    imageList.add(
      SlideModel(
        "https://i1.wp.com/dadanizm.wpcomstaging.com/wp-content/uploads/2020/07/beyonce_black-is-king.jpg?fit=1024%2C512&ssl=1",
        "Beyonc?????den Afrika k??lt??r??ne selam ??akan co??kulu bir g??rsel alb??m: Black is King"
      )
    )
    imageList.add(
      SlideModel(
        "https://i2.wp.com/dadanizm.wpcomstaging.com/wp-content/uploads/2021/07/halsey.png?fit=1024%2C541&ssl=1",
        "If I Can???t Have Love, I Want Power: Yeni alb??m ??ncesi Halsey???e dadan??yoruz"
      )
    )
    imageList.add(
      SlideModel(
        "https://i2.wp.com/dadanizm.wpcomstaging.com/wp-content/uploads/2021/06/amy-winehouse-bbc-belgesel.jpeg?fit=1024%2C803&ssl=1",
        "Bir hayattan ka?? hikaye ????kar: Amy Winehouse ??l??m??n??n 10. y??l??nda yeni bir kitap ve belgeselle an??l??yor"
      )
    )
    imageList.add(
      SlideModel(
        "https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/adele-episode-1789-pictured-host-adele-during-the-monologue-news-photo-1623850606.jpg",
        "Adele Saturday Night Live ile d??n????e haz??rlan??yor"
      )
    )
    imageList.add(
      SlideModel(
        "https://i0.wp.com/dadanizm.wpcomstaging.com/wp-content/uploads/2020/08/the-weeknd-1.jpg?fit=1024%2C686&ssl=1",
        "??nce TikTok, sonra Spotify: The Weeknd ve dijital maceralar??"
      )
    )
    imageList.add(
      SlideModel(
        "https://i0.wp.com/dadanizm.wpcomstaging.com/wp-content/uploads/2020/02/bob-marley_75.jpeg?fit=1024%2C614&ssl=1",
        "A????n m??zi??in sesini: Bob Marley 75 ya????nda"
      )
    )

    val imageSlider = findViewById<ImageSlider>(R.id.image_slider)
    imageSlider.setImageList(imageList)


    getSongs1()
    getSongs2()
    getSongs3()
    getSongs4()


  }



  private fun getSongs1() {

    recyclerView = findViewById(R.id.recyclerView)
    recyclerView!!.setLayoutManager(
      LinearLayoutManager(
        this,
        LinearLayoutManager.HORIZONTAL,
        false
      )
    )
    songData = java.util.ArrayList()
    databaseReference = FirebaseDatabase.getInstance().getReference("dununvebugununhitleri")
    databaseReference!!.addListenerForSingleValueEvent(object : ValueEventListener {
      override fun onDataChange(dataSnapshot: DataSnapshot) {
        for (ds in dataSnapshot.children) {
         val fetchDatalist = ds.getValue(SongData::class.java)
          if (fetchDatalist != null) {
            songData!!.add(fetchDatalist)
          }
        }
        animalsAdapter = AnimalsAdapter(songData!!)
        recyclerView!!.setAdapter(animalsAdapter)
      }

      override fun onCancelled(databaseError: DatabaseError) {}
    })

  }

  private fun getSongs2() {

    recyclerView2 = findViewById(R.id.recyclerAnimals2)
    recyclerView2!!.setLayoutManager(
      LinearLayoutManager(
        this,
        LinearLayoutManager.HORIZONTAL,
        false
      )
    )
    songData2 = java.util.ArrayList()
    databaseReference2 = FirebaseDatabase.getInstance().getReference("singers")
    databaseReference2!!.addListenerForSingleValueEvent(object : ValueEventListener {
      override fun onDataChange(dataSnapshot: DataSnapshot) {
        for (ds in dataSnapshot.children) {
          val fetchDatalist = ds.getValue(SongData::class.java)
          if (fetchDatalist != null) {
            songData2!!.add(fetchDatalist)
          }
        }
        animalsAdapter2 = AnimalsAdapter(songData2!!)
        recyclerView2!!.setAdapter(animalsAdapter2)
      }

      override fun onCancelled(databaseError: DatabaseError) {}
    })
  }

  private fun getSongs3() {

    recyclerView3 = findViewById(R.id.recyclerAnimals3)
    recyclerView3!!.setLayoutManager(
      LinearLayoutManager(
        this,
        LinearLayoutManager.HORIZONTAL,
        false
      )
    )
    songData3 = java.util.ArrayList()
    databaseReference3 = FirebaseDatabase.getInstance().getReference("youlikeit")
    databaseReference3!!.addListenerForSingleValueEvent(object : ValueEventListener {
      override fun onDataChange(dataSnapshot: DataSnapshot) {
        for (ds in dataSnapshot.children) {
          val fetchDatalist = ds.getValue(SongData::class.java)
          if (fetchDatalist != null) {
            songData3!!.add(fetchDatalist)
          }
        }
        animalsAdapter3 = AnimalsAdapter(songData3!!)
        recyclerView3!!.setAdapter(animalsAdapter3)
      }

      override fun onCancelled(databaseError: DatabaseError) {}
    })
  }

  private fun getSongs4() {

    recyclerView4 = findViewById(R.id.recyclerAnimals4)
    recyclerView4!!.setLayoutManager(
      LinearLayoutManager(
        this,
        LinearLayoutManager.HORIZONTAL,
        false
      )
    )
    songData4 = java.util.ArrayList()
    databaseReference4 = FirebaseDatabase.getInstance().getReference("chill")
    databaseReference4!!.addListenerForSingleValueEvent(object : ValueEventListener {
      override fun onDataChange(dataSnapshot: DataSnapshot) {
        for (ds in dataSnapshot.children) {
          val fetchDatalist = ds.getValue(SongData::class.java)
          if (fetchDatalist != null) {
            songData4!!.add(fetchDatalist)
          }
        }
        animalsAdapter4 = AnimalsAdapter(songData4!!)
        recyclerView4!!.setAdapter(animalsAdapter4)
      }

      override fun onCancelled(databaseError: DatabaseError) {}
    })


  }
}




