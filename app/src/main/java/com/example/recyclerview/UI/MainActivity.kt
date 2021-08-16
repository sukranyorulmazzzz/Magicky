package com.example.recyclerview.UI

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.widget.PopupMenu
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.models.SlideModel
import com.example.recyclerview.SongData
import com.example.recyclerview.R
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth

import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_home_yeni.*


class MainActivity : AppCompatActivity() {

  var recyclerView: RecyclerView? = null
  var recyclerView2: RecyclerView? = null
  var recyclerView3: RecyclerView? = null
  var recyclerView4: RecyclerView? = null
  private lateinit var songData: java.util.ArrayList<SongData>
  private lateinit var songData2: java.util.ArrayList<SongData>
  private lateinit var songData3: java.util.ArrayList<SongData>
  private lateinit var songData4: java.util.ArrayList<SongData>
  var animalsAdapter: AnimalsAdapter? = null
  var animalsAdapter2: AnimalsAdapter? = null
  var animalsAdapter3: AnimalsAdapter? = null
  var animalsAdapter4: AnimalsAdapter? = null
  var databaseReference: DatabaseReference? = null
  var databaseReference2: DatabaseReference? = null
  var databaseReference3: DatabaseReference? = null
  var databaseReference4: DatabaseReference? = null


  val imageList= java.util.ArrayList<SlideModel>()
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_home_yeni)

  imageview_options.setOnClickListener{
    val popupMenu=PopupMenu(this,it)
    popupMenu.setOnMenuItemClickListener {item->
      when(item.itemId){
        R.id.menu_home ->{
          val intent=Intent(this,MainActivity::class.java)
          startActivity(intent)
          true
        }  R.id.menu_profile ->{
          val intent=Intent(this,ProfileActivity::class.java)
          startActivity(intent)
          true
        }
        R.id.menu_settings ->{
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


    imageList.add(SlideModel("https://i1.wp.com/dadanizm.wpcomstaging.com/wp-content/uploads/2020/07/beyonce_black-is-king.jpg?fit=1024%2C512&ssl=1","Beyoncé’den Afrika kültürüne selam çakan coşkulu bir görsel albüm: Black is King"))
    imageList.add(SlideModel("https://i2.wp.com/dadanizm.wpcomstaging.com/wp-content/uploads/2021/07/halsey.png?fit=1024%2C541&ssl=1","If I Can’t Have Love, I Want Power: Yeni albüm öncesi Halsey’e dadanıyoruz"))
    imageList.add(SlideModel("https://i2.wp.com/dadanizm.wpcomstaging.com/wp-content/uploads/2021/06/amy-winehouse-bbc-belgesel.jpeg?fit=1024%2C803&ssl=1","Bir hayattan kaç hikaye çıkar: Amy Winehouse ölümünün 10. yılında yeni bir kitap ve belgeselle anılıyor"))
    imageList.add(SlideModel("https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/adele-episode-1789-pictured-host-adele-during-the-monologue-news-photo-1623850606.jpg","Adele Saturday Night Live ile dönüşe hazırlanıyor"))
    imageList.add(SlideModel("https://i0.wp.com/dadanizm.wpcomstaging.com/wp-content/uploads/2020/08/the-weeknd-1.jpg?fit=1024%2C686&ssl=1","Önce TikTok, sonra Spotify: The Weeknd ve dijital maceraları"))
    imageList.add(SlideModel("https://i0.wp.com/dadanizm.wpcomstaging.com/wp-content/uploads/2020/02/bob-marley_75.jpeg?fit=1024%2C614&ssl=1","Açın müziğin sesini: Bob Marley 75 yaşında"))

    val imageSlider=findViewById<ImageSlider>(R.id.image_slider)
    imageSlider.setImageList(imageList)


    getSongs1()
    getSongs2()
    getSongs3()
    getSongs4()


  }
  /**ok now create new activity*/


  private fun getSongs1() {

    recyclerView = findViewById(R.id.recyclerView)
    recyclerView!!.setLayoutManager(LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false))
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
  }  private fun getSongs2() {

    recyclerView2 = findViewById(R.id.recyclerAnimals2)
    recyclerView2!!.setLayoutManager(LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false))
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
  } private fun getSongs3() {

    recyclerView3 = findViewById(R.id.recyclerAnimals3)
    recyclerView3!!.setLayoutManager(LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false))
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
  }private fun getSongs4() {

    recyclerView4 = findViewById(R.id.recyclerAnimals4)
    recyclerView4!!.setLayoutManager(LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false))
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



