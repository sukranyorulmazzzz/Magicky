package com.example.recyclerview


import java.io.Serializable

class SongData : Serializable {


  /**set Data*/
  var name :String? = null
  var info:String? = null
  var img:String? = null
  var songId:Int? = null


  constructor(){}

  constructor(
    name:String?,
    info:String?,
    img:String?,
    songId:Int?
  ){
    this.name = name
    this.info = info
    this.img = img
    this.songId=songId
  }

}