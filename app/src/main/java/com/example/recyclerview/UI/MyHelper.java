package com.example.recyclerview.UI;


import com.example.recyclerview.Song;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;

public class MyHelper {
    Realm realm;
    RealmResults<Song> song;
    public MyHelper(Realm realm){

        this.realm=realm;
    }
    public void selectFromDB(){
        song=realm.where(Song.class).findAll();

    }
    public ArrayList<Song> justRefresh(){
        ArrayList<Song> listitem=new ArrayList<>();
        for (Song s:song){
            listitem.add(s);
        }
        return listitem;
    }
}
