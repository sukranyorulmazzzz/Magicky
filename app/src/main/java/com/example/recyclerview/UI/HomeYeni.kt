package com.example.recyclerview.UI

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.PopupMenu
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.models.SlideModel
import com.example.recyclerview.SongData
import com.example.recyclerview.R
import com.google.firebase.auth.FirebaseAuth

import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_home_yeni.*


class HomeYeni : AppCompatActivity() {
    lateinit var mDataBase: DatabaseReference
    var recyclerView: RecyclerView? = null
    private lateinit var songData: java.util.ArrayList<SongData>
    var animalsAdapter: AnimalsAdapter? = null
    var databaseReference: DatabaseReference? = null

    private lateinit var recyclerView2: RecyclerView
    private lateinit var recyclerView3: RecyclerView
    private lateinit var recyclerView4: RecyclerView
    private lateinit var animaList:ArrayList<SongData>
    private lateinit var animaList2:ArrayList<SongData>
    private lateinit var animaList3:ArrayList<SongData>
    private lateinit var animaList4:ArrayList<SongData>
    private lateinit var mAdapter:AnimalsAdapter
    private lateinit var mAdapter2:AnimalsAdapter
    private lateinit var mAdapter3:AnimalsAdapter
    private lateinit var mAdapter4:AnimalsAdapter

    private lateinit var firebaseAuth: FirebaseAuth
    val imageList= java.util.ArrayList<SlideModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_yeni)


        imageview_options.setOnClickListener{
            val popupMenu=PopupMenu(this,it)
            popupMenu.setOnMenuItemClickListener { item->
                when(item.itemId){
                    R.id.menu_open_profile->{
                        startActivity(Intent(this,ProfileActivity::class.java))
                        true
                    }
                    R.id.logout->{
                        startActivity(Intent(this,LoginActivity::class.java))
                        true


                    }
                    else ->
                        false
                }
            }
            popupMenu.inflate(R.menu.menu)
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

        /**initialized*/
     //   animaList2 = ArrayList()
      //  animaList3 = ArrayList()
      //  animaList4 = ArrayList()

       // mAdapter = AnimalsAdapter(this,animaList)
      //  mAdapter2= AnimalsAdapter(this,animaList2)
      //  mAdapter3= AnimalsAdapter(this,animaList3)
      //  mAdapter4= AnimalsAdapter(this,animaList4)

      //  recyclerView.layoutManager=LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
      //  recyclerView.adapter=mAdapter

        getSongs()
      //  getSongs2()
       // getSongs3()
       // getSongs4()


    }
    /**ok now create new activity*/


    private fun getSongs() {

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
    }
            }






   /* private fun getSongs4() {

        mDataBase = FirebaseDatabase.getInstance().getReference("chill")
        mDataBase.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    for (animalSnapshot in snapshot.children) {
                        val animal = animalSnapshot.getValue(SongData::class.java)
                        animaList4.add(animal!!)
                    }
                    recyclerAnimals4.adapter = mAdapter4
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(
                    this@HomeYeni,
                    error.message, Toast.LENGTH_SHORT
                ).show()
            }




        })
    }
    private fun getSongs3() {

        mDataBase = FirebaseDatabase.getInstance().getReference("youlikeit")
        mDataBase.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    for (animalSnapshot in snapshot.children) {
                        val animal = animalSnapshot.getValue(SongData::class.java)
                        animaList3.add(animal!!)
                    }
                    recyclerAnimals3.adapter = mAdapter3
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(
                    this@HomeYeni,
                    error.message, Toast.LENGTH_SHORT
                ).show()
            }




        })
    }
    private fun getSongs2() {

        mDataBase = FirebaseDatabase.getInstance().getReference("singers")
        mDataBase.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    for (dataSnapshot in snapshot.children) {
                        val animal = dataSnapshot.getValue(SongData::class.java)
                        animaList2.add(animal!!)
                    }
                    recyclerAnimals2.adapter = mAdapter2
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(
                    this@HomeYeni,
                    error.message, Toast.LENGTH_SHORT
                ).show()
            }

        })}
*/


