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
import com.example.recyclerview.SongData
import com.google.firebase.database.*
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_new.*
import java.util.ArrayList

class NewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        var helperAdapter2: HelperAdapter2? = null
        var recyclerViewsSecond: RecyclerView? = null
        lateinit var songData: java.util.ArrayList<Song>
        var backbutton:ImageView? = null
        var databaseReference: DatabaseReference? = null

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new)

        backbutton=findViewById(R.id.backbuttonnew)
        backbutton!!.setOnClickListener {
            val intent=Intent(this,MainActivity::class.java)
            startActivity(intent)
        }


        recyclerViewsSecond = findViewById(R.id.recyclerViewSecond)
        val intent = this.intent
        val bundle = intent.extras
        val name: TextView
        val info: TextView
        val background: ImageView


        val fetchData = bundle!!.getSerializable("key") as SongData?
        recyclerViewsSecond!!.setLayoutManager(LinearLayoutManager(this))

        val arrayList = ArrayList<String?>()

        name = findViewById(R.id.name)
        info = findViewById(R.id.info)
        background=findViewById(R.id.background)


        name.text = fetchData!!.name
        info.text = fetchData.info
        Picasso.get().load(fetchData.background).into(background)

        if (fetchData.songId == 1) {

            songData = java.util.ArrayList()
            databaseReference = FirebaseDatabase.getInstance().getReference("Songs/01/01")
            databaseReference!!.addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    for (ds in dataSnapshot.children) {
                        val fetchDatalist = ds.getValue(Song::class.java)
                        if (fetchDatalist != null) {
                            songData!!.add(fetchDatalist)
                        }
                    }
                    helperAdapter2 = HelperAdapter2(songData!!)
                    recyclerViewSecond!!.setAdapter(helperAdapter2)
                }

                override fun onCancelled(databaseError: DatabaseError) {}
            })
        }
        if (fetchData.songId == 2) {

            songData = java.util.ArrayList()
            databaseReference = FirebaseDatabase.getInstance().getReference("Songs/01/02")
            databaseReference!!.addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    for (ds in dataSnapshot.children) {
                        val fetchDatalist = ds.getValue(Song::class.java)
                        if (fetchDatalist != null) {
                            songData!!.add(fetchDatalist)
                        }
                    }
                    helperAdapter2 = HelperAdapter2(songData!!)
                    recyclerViewSecond!!.setAdapter(helperAdapter2)
                }

                override fun onCancelled(databaseError: DatabaseError) {}
            })
        }
        if (fetchData.songId == 3) {

            songData = java.util.ArrayList()
            databaseReference = FirebaseDatabase.getInstance().getReference("Songs/01/03")
            databaseReference!!.addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    for (ds in dataSnapshot.children) {
                        val fetchDatalist = ds.getValue(Song::class.java)
                        if (fetchDatalist != null) {
                            songData!!.add(fetchDatalist)
                        }
                    }
                    helperAdapter2 = HelperAdapter2(songData!!)
                    recyclerViewSecond!!.setAdapter(helperAdapter2)
                }

                override fun onCancelled(databaseError: DatabaseError) {}
            })
        }
        if (fetchData.songId == 4) {

            songData = java.util.ArrayList()
            databaseReference = FirebaseDatabase.getInstance().getReference("Songs/01/04")
            databaseReference!!.addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    for (ds in dataSnapshot.children) {
                        val fetchDatalist = ds.getValue(Song::class.java)
                        if (fetchDatalist != null) {
                            songData!!.add(fetchDatalist)
                        }
                    }
                    helperAdapter2 = HelperAdapter2(songData!!)
                    recyclerViewSecond!!.setAdapter(helperAdapter2)
                }

                override fun onCancelled(databaseError: DatabaseError) {}
            })
        }
        if (fetchData.songId == 5) {

            songData = java.util.ArrayList()
            databaseReference = FirebaseDatabase.getInstance().getReference("Songs/01/05")
            databaseReference!!.addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    for (ds in dataSnapshot.children) {
                        val fetchDatalist = ds.getValue(Song::class.java)
                        if (fetchDatalist != null) {
                            songData!!.add(fetchDatalist)
                        }
                    }
                    helperAdapter2 = HelperAdapter2(songData!!)
                    recyclerViewSecond!!.setAdapter(helperAdapter2)
                }

                override fun onCancelled(databaseError: DatabaseError) {}
            })
        }
        if (fetchData.songId == 6) {

            songData = java.util.ArrayList()
            databaseReference = FirebaseDatabase.getInstance().getReference("Songs/01/06")
            databaseReference!!.addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    for (ds in dataSnapshot.children) {
                        val fetchDatalist = ds.getValue(Song::class.java)
                        if (fetchDatalist != null) {
                            songData!!.add(fetchDatalist)
                        }
                    }
                    helperAdapter2 = HelperAdapter2(songData!!)
                    recyclerViewSecond!!.setAdapter(helperAdapter2)
                }

                override fun onCancelled(databaseError: DatabaseError) {}
            })
        }
        if (fetchData.songId == 7) {

            songData = java.util.ArrayList()
            databaseReference = FirebaseDatabase.getInstance().getReference("Songs/01/07")
            databaseReference!!.addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    for (ds in dataSnapshot.children) {
                        val fetchDatalist = ds.getValue(Song::class.java)
                        if (fetchDatalist != null) {
                            songData!!.add(fetchDatalist)
                        }
                    }
                    helperAdapter2 = HelperAdapter2(songData!!)
                    recyclerViewSecond!!.setAdapter(helperAdapter2)
                }

                override fun onCancelled(databaseError: DatabaseError) {}
            })
        }
        if (fetchData.songId == 8) {

            songData = java.util.ArrayList()
            databaseReference = FirebaseDatabase.getInstance().getReference("Songs/01/08")
            databaseReference!!.addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    for (ds in dataSnapshot.children) {
                        val fetchDatalist = ds.getValue(Song::class.java)
                        if (fetchDatalist != null) {
                            songData!!.add(fetchDatalist)
                        }
                    }
                    helperAdapter2 = HelperAdapter2(songData!!)
                    recyclerViewSecond!!.setAdapter(helperAdapter2)
                }

                override fun onCancelled(databaseError: DatabaseError) {}
            })
        }
        if (fetchData.songId == 21) {

            songData = java.util.ArrayList()
            databaseReference = FirebaseDatabase.getInstance().getReference("Songs/02/01")
            databaseReference!!.addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    for (ds in dataSnapshot.children) {
                        val fetchDatalist = ds.getValue(Song::class.java)
                        if (fetchDatalist != null) {
                            songData!!.add(fetchDatalist)
                        }
                    }
                    helperAdapter2 = HelperAdapter2(songData!!)
                    recyclerViewSecond!!.setAdapter(helperAdapter2)
                }

                override fun onCancelled(databaseError: DatabaseError) {}
            })
        }
        if (fetchData.songId == 22) {

            songData = java.util.ArrayList()
            databaseReference = FirebaseDatabase.getInstance().getReference("Songs/02/02")
            databaseReference!!.addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    for (ds in dataSnapshot.children) {
                        val fetchDatalist = ds.getValue(Song::class.java)
                        if (fetchDatalist != null) {
                            songData!!.add(fetchDatalist)
                        }
                    }
                    helperAdapter2 = HelperAdapter2(songData!!)
                    recyclerViewSecond!!.setAdapter(helperAdapter2)
                }

                override fun onCancelled(databaseError: DatabaseError) {}
            })
        }
        if (fetchData.songId == 23) {

            songData = java.util.ArrayList()
            databaseReference = FirebaseDatabase.getInstance().getReference("Songs/02/03")
            databaseReference!!.addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    for (ds in dataSnapshot.children) {
                        val fetchDatalist = ds.getValue(Song::class.java)
                        if (fetchDatalist != null) {
                            songData!!.add(fetchDatalist)
                        }
                    }
                    helperAdapter2 = HelperAdapter2(songData!!)
                    recyclerViewSecond!!.setAdapter(helperAdapter2)
                }

                override fun onCancelled(databaseError: DatabaseError) {}
            })
        }
        if (fetchData.songId == 24) {

            songData = java.util.ArrayList()
            databaseReference = FirebaseDatabase.getInstance().getReference("Songs/02/04")
            databaseReference!!.addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    for (ds in dataSnapshot.children) {
                        val fetchDatalist = ds.getValue(Song::class.java)
                        if (fetchDatalist != null) {
                            songData!!.add(fetchDatalist)
                        }
                    }
                    helperAdapter2 = HelperAdapter2(songData!!)
                    recyclerViewSecond!!.setAdapter(helperAdapter2)
                }

                override fun onCancelled(databaseError: DatabaseError) {}
            })
        }
        if (fetchData.songId == 25) {

            songData = java.util.ArrayList()
            databaseReference = FirebaseDatabase.getInstance().getReference("Songs/02/05")
            databaseReference!!.addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    for (ds in dataSnapshot.children) {
                        val fetchDatalist = ds.getValue(Song::class.java)
                        if (fetchDatalist != null) {
                            songData!!.add(fetchDatalist)
                        }
                    }
                    helperAdapter2 = HelperAdapter2(songData!!)
                    recyclerViewSecond!!.setAdapter(helperAdapter2)
                }

                override fun onCancelled(databaseError: DatabaseError) {}
            })
        }
        if (fetchData.songId == 26) {

            songData = java.util.ArrayList()
            databaseReference = FirebaseDatabase.getInstance().getReference("Songs/02/06")
            databaseReference!!.addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    for (ds in dataSnapshot.children) {
                        val fetchDatalist = ds.getValue(Song::class.java)
                        if (fetchDatalist != null) {
                            songData!!.add(fetchDatalist)
                        }
                    }
                    helperAdapter2 = HelperAdapter2(songData!!)
                    recyclerViewSecond!!.setAdapter(helperAdapter2)
                }

                override fun onCancelled(databaseError: DatabaseError) {}
            })
        }
        if (fetchData.songId == 27) {

            songData = java.util.ArrayList()
            databaseReference = FirebaseDatabase.getInstance().getReference("Songs/02/07")
            databaseReference!!.addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    for (ds in dataSnapshot.children) {
                        val fetchDatalist = ds.getValue(Song::class.java)
                        if (fetchDatalist != null) {
                            songData!!.add(fetchDatalist)
                        }
                    }
                    helperAdapter2 = HelperAdapter2(songData!!)
                    recyclerViewSecond!!.setAdapter(helperAdapter2)
                }

                override fun onCancelled(databaseError: DatabaseError) {}
            })
        }
        if (fetchData.songId == 28) {

            songData = java.util.ArrayList()
            databaseReference = FirebaseDatabase.getInstance().getReference("Songs/02/08")
            databaseReference!!.addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    for (ds in dataSnapshot.children) {
                        val fetchDatalist = ds.getValue(Song::class.java)
                        if (fetchDatalist != null) {
                            songData!!.add(fetchDatalist)
                        }
                    }
                    helperAdapter2 = HelperAdapter2(songData!!)
                    recyclerViewSecond!!.setAdapter(helperAdapter2)
                }

                override fun onCancelled(databaseError: DatabaseError) {}
            })
        }
        if (fetchData.songId == 31) {

            songData = java.util.ArrayList()
            databaseReference = FirebaseDatabase.getInstance().getReference("Songs/03/01")
            databaseReference!!.addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    for (ds in dataSnapshot.children) {
                        val fetchDatalist = ds.getValue(Song::class.java)
                        if (fetchDatalist != null) {
                            songData!!.add(fetchDatalist)
                        }
                    }
                    helperAdapter2 = HelperAdapter2(songData!!)
                    recyclerViewSecond!!.setAdapter(helperAdapter2)
                }

                override fun onCancelled(databaseError: DatabaseError) {}
            })
        }
        if (fetchData.songId == 32) {

            songData = java.util.ArrayList()
            databaseReference = FirebaseDatabase.getInstance().getReference("Songs/03/02")
            databaseReference!!.addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    for (ds in dataSnapshot.children) {
                        val fetchDatalist = ds.getValue(Song::class.java)
                        if (fetchDatalist != null) {
                            songData!!.add(fetchDatalist)
                        }
                    }
                    helperAdapter2 = HelperAdapter2(songData!!)
                    recyclerViewSecond!!.setAdapter(helperAdapter2)
                }

                override fun onCancelled(databaseError: DatabaseError) {}
            })
        }
        if (fetchData.songId == 33) {

            songData = java.util.ArrayList()
            databaseReference = FirebaseDatabase.getInstance().getReference("Songs/03/03")
            databaseReference!!.addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    for (ds in dataSnapshot.children) {
                        val fetchDatalist = ds.getValue(Song::class.java)
                        if (fetchDatalist != null) {
                            songData!!.add(fetchDatalist)
                        }
                    }
                    helperAdapter2 = HelperAdapter2(songData!!)
                    recyclerViewSecond!!.setAdapter(helperAdapter2)
                }

                override fun onCancelled(databaseError: DatabaseError) {}
            })
        }
        if (fetchData.songId == 34) {

            songData = java.util.ArrayList()
            databaseReference = FirebaseDatabase.getInstance().getReference("Songs/03/04")
            databaseReference!!.addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    for (ds in dataSnapshot.children) {
                        val fetchDatalist = ds.getValue(Song::class.java)
                        if (fetchDatalist != null) {
                            songData!!.add(fetchDatalist)
                        }
                    }
                    helperAdapter2 = HelperAdapter2(songData!!)
                    recyclerViewSecond!!.setAdapter(helperAdapter2)
                }

                override fun onCancelled(databaseError: DatabaseError) {}
            })
        }
        if (fetchData.songId == 35) {

            songData = java.util.ArrayList()
            databaseReference = FirebaseDatabase.getInstance().getReference("Songs/03/05")
            databaseReference!!.addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    for (ds in dataSnapshot.children) {
                        val fetchDatalist = ds.getValue(Song::class.java)
                        if (fetchDatalist != null) {
                            songData!!.add(fetchDatalist)
                        }
                    }
                    helperAdapter2 = HelperAdapter2(songData!!)
                    recyclerViewSecond!!.setAdapter(helperAdapter2)
                }

                override fun onCancelled(databaseError: DatabaseError) {}
            })
        }
        if (fetchData.songId == 36) {

            songData = java.util.ArrayList()
            databaseReference = FirebaseDatabase.getInstance().getReference("Songs/03/06")
            databaseReference!!.addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    for (ds in dataSnapshot.children) {
                        val fetchDatalist = ds.getValue(Song::class.java)
                        if (fetchDatalist != null) {
                            songData!!.add(fetchDatalist)
                        }
                    }
                    helperAdapter2 = HelperAdapter2(songData!!)
                    recyclerViewSecond!!.setAdapter(helperAdapter2)
                }

                override fun onCancelled(databaseError: DatabaseError) {}
            })
        }
        if (fetchData.songId == 37) {

            songData = java.util.ArrayList()
            databaseReference = FirebaseDatabase.getInstance().getReference("Songs/03/07")
            databaseReference!!.addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    for (ds in dataSnapshot.children) {
                        val fetchDatalist = ds.getValue(Song::class.java)
                        if (fetchDatalist != null) {
                            songData!!.add(fetchDatalist)
                        }
                    }
                    helperAdapter2 = HelperAdapter2(songData!!)
                    recyclerViewSecond!!.setAdapter(helperAdapter2)
                }

                override fun onCancelled(databaseError: DatabaseError) {}
            })
        }
        if (fetchData.songId == 38) {

            songData = java.util.ArrayList()
            databaseReference = FirebaseDatabase.getInstance().getReference("Songs/03/08")
            databaseReference!!.addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    for (ds in dataSnapshot.children) {
                        val fetchDatalist = ds.getValue(Song::class.java)
                        if (fetchDatalist != null) {
                            songData!!.add(fetchDatalist)
                        }
                    }
                    helperAdapter2 = HelperAdapter2(songData!!)
                    recyclerViewSecond!!.setAdapter(helperAdapter2)
                }

                override fun onCancelled(databaseError: DatabaseError) {}
            })
        }
        if (fetchData.songId == 41) {

            songData = java.util.ArrayList()
            databaseReference = FirebaseDatabase.getInstance().getReference("Songs/04/01")
            databaseReference!!.addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    for (ds in dataSnapshot.children) {
                        val fetchDatalist = ds.getValue(Song::class.java)
                        if (fetchDatalist != null) {
                            songData!!.add(fetchDatalist)
                        }
                    }
                    helperAdapter2 = HelperAdapter2(songData!!)
                    recyclerViewSecond!!.setAdapter(helperAdapter2)
                }

                override fun onCancelled(databaseError: DatabaseError) {}
            })
        }
        if (fetchData.songId == 42) {

            songData = java.util.ArrayList()
            databaseReference = FirebaseDatabase.getInstance().getReference("Songs/04/02")
            databaseReference!!.addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    for (ds in dataSnapshot.children) {
                        val fetchDatalist = ds.getValue(Song::class.java)
                        if (fetchDatalist != null) {
                            songData!!.add(fetchDatalist)
                        }
                    }
                    helperAdapter2 = HelperAdapter2(songData!!)
                    recyclerViewSecond!!.setAdapter(helperAdapter2)
                }

                override fun onCancelled(databaseError: DatabaseError) {}
            })
        }
        if (fetchData.songId == 43) {

            songData = java.util.ArrayList()
            databaseReference = FirebaseDatabase.getInstance().getReference("Songs/04/03")
            databaseReference!!.addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    for (ds in dataSnapshot.children) {
                        val fetchDatalist = ds.getValue(Song::class.java)
                        if (fetchDatalist != null) {
                            songData!!.add(fetchDatalist)
                        }
                    }
                    helperAdapter2 = HelperAdapter2(songData!!)
                    recyclerViewSecond!!.setAdapter(helperAdapter2)
                }

                override fun onCancelled(databaseError: DatabaseError) {}
            })
        }
        if (fetchData.songId == 44) {

            songData = java.util.ArrayList()
            databaseReference = FirebaseDatabase.getInstance().getReference("Songs/04/04")
            databaseReference!!.addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    for (ds in dataSnapshot.children) {
                        val fetchDatalist = ds.getValue(Song::class.java)
                        if (fetchDatalist != null) {
                            songData!!.add(fetchDatalist)
                        }
                    }
                    helperAdapter2 = HelperAdapter2(songData!!)
                    recyclerViewSecond!!.setAdapter(helperAdapter2)
                }

                override fun onCancelled(databaseError: DatabaseError) {}
            })
        }
        if (fetchData.songId == 45) {

            songData = java.util.ArrayList()
            databaseReference = FirebaseDatabase.getInstance().getReference("Songs/04/05")
            databaseReference!!.addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    for (ds in dataSnapshot.children) {
                        val fetchDatalist = ds.getValue(Song::class.java)
                        if (fetchDatalist != null) {
                            songData!!.add(fetchDatalist)
                        }
                    }
                    helperAdapter2 = HelperAdapter2(songData!!)
                    recyclerViewSecond!!.setAdapter(helperAdapter2)
                }

                override fun onCancelled(databaseError: DatabaseError) {}
            })
        }
        if (fetchData.songId == 46) {

            songData = java.util.ArrayList()
            databaseReference = FirebaseDatabase.getInstance().getReference("Songs/04/06")
            databaseReference!!.addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    for (ds in dataSnapshot.children) {
                        val fetchDatalist = ds.getValue(Song::class.java)
                        if (fetchDatalist != null) {
                            songData!!.add(fetchDatalist)
                        }
                    }
                    helperAdapter2 = HelperAdapter2(songData!!)
                    recyclerViewSecond!!.setAdapter(helperAdapter2)
                }

                override fun onCancelled(databaseError: DatabaseError) {}
            })
        }
        if (fetchData.songId == 47) {

            songData = java.util.ArrayList()
            databaseReference = FirebaseDatabase.getInstance().getReference("Songs/04/07")
            databaseReference!!.addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    for (ds in dataSnapshot.children) {
                        val fetchDatalist = ds.getValue(Song::class.java)
                        if (fetchDatalist != null) {
                            songData!!.add(fetchDatalist)
                        }
                    }
                    helperAdapter2 = HelperAdapter2(songData!!)
                    recyclerViewSecond!!.setAdapter(helperAdapter2)
                }

                override fun onCancelled(databaseError: DatabaseError) {}
            })
        }
        if (fetchData.songId == 48) {

            songData = java.util.ArrayList()
            databaseReference = FirebaseDatabase.getInstance().getReference("Songs/04/08")
            databaseReference!!.addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    for (ds in dataSnapshot.children) {
                        val fetchDatalist = ds.getValue(Song::class.java)
                        if (fetchDatalist != null) {
                            songData!!.add(fetchDatalist)
                        }
                    }
                    helperAdapter2 = HelperAdapter2(songData!!)
                    recyclerViewSecond!!.setAdapter(helperAdapter2)
                }

                override fun onCancelled(databaseError: DatabaseError) {}
            })
        }
    }
}




