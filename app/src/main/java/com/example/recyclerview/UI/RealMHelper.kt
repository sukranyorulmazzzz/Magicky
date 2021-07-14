package com.example.recyclerview.UI

import com.example.recyclerview.Model.Tasks
import io.realm.Realm
import io.realm.Sort

class RealMHelper {
    var realm = Realm.getDefaultInstance()
    fun insertData(t: Tasks) {
        val num = realm.where(Tasks::class.java).max("task_id")
        val nextID: Int
        nextID = if (num == null) {
            0
        } else {
            num.toInt() + 1
        }
        t.task_id = nextID
        realm.beginTransaction()
        realm.copyToRealm(t)
        realm.commitTransaction()
    }

    val data: List<Tasks>
        get() = realm.where(Tasks::class.java).sort("task_id", Sort.DESCENDING).findAll()

    fun editData(id: Int, task_name: String?) {
        val item = realm.where(
            Tasks::class.java
        ).equalTo("task_id", id).findFirst()
        realm.executeTransaction { realm ->
            item!!.task_name = task_name
            realm.copyFromRealm(item)
        }
    }

    fun deleteData(id: Int) {
        val item = realm.where(
            Tasks::class.java
        ).equalTo("task_id", id).findFirst()
        realm.executeTransaction { item!!.deleteFromRealm() }
    }
}