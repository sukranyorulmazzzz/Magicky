package com.example.recyclerview;

public class Song {

    public String songName, image, status;

    public Song(){

    }

    public String getsongName() {
        return songName;
    }

    public void setsongName(String songName) {
        this.songName = songName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Song(String songName, String image, String status) {
        this.songName = songName;
        this.image = image;
        this.status = status;
    }
}
