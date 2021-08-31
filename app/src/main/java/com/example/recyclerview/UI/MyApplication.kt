package com.example.recyclerview.UI

import android.app.Application
import io.realm.Realm
import io.realm.RealmConfiguration

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
        val configuration = RealmConfiguration.Builder().name("RealmData.realm").build()
        Realm.setDefaultConfiguration(configuration)
    }
}