package com.example.recyclerview

import java.io.Serializable

class SongData : Serializable {


    /**set Data*/
    var name :String? = null
    var info:String? = null
    var img:String? = null
    var songName: String? = null
    var songName2: String? = null
    var songUrl: String? = null


    constructor(){}

    constructor(
        name:String?,
        info:String?,
        img:String?,
        songName:String?,
        songName2:String?,
        songUrl:String?

    ){
        this.name = name
        this.info = info
        this.img = img
        this.songName = songName
        this.songName2 = songName2
        this.songUrl = songUrl
    }

}