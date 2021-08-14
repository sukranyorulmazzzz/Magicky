package com.example.recyclerview

import java.io.Serializable

class SongData : Serializable {


  /**set Data*/
  var name :String? = null
  var info:String? = null
  var img:String? = null
  var songName: String? = null
  var songName2: String? = null
  var songName3: String? = null
  var songName4: String? = null
  var songName5: String? = null
  var songName6: String? = null
  var songName7: String? = null
  var songName8: String? = null
  var songName9: String? = null
  var songName91: String? = null
  var path: String? = null
  var duration: String? = null


  constructor(){}

  constructor(
    name:String?,
    info:String?,
    img:String?,
    songName:String?,
    songName2:String?,
    songName3:String?,
    songName4:String?,
    songName5:String?,
    songName6:String?,
    songName7:String?,
    songName8:String?,
    songName9:String?,
    songName91:String?,
    path:String?,
    duration:String?

  ){
    this.name = name
    this.info = info
    this.img = img
    this.songName = songName
    this.songName2 = songName2
    this.songName3 = songName3
    this.songName4 = songName4
    this.songName5 = songName5
    this.songName6 = songName6
    this.songName7 = songName7
    this.songName8 = songName8
    this.songName9 = songName9
    this.songName91 = songName91
    this.path = path
    this.duration = duration
  }

}