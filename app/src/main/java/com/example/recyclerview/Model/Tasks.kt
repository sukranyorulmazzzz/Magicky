package com.example.recyclerview.Model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class Tasks : RealmObject {
    @PrimaryKey
    var task_id = 0
    var task_name: String? = null

    constructor() {}
    constructor(task_name: String?) {
        this.task_name = task_name
    }
}