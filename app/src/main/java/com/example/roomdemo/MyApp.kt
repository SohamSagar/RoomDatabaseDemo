package com.example.roomdemo

import android.app.Application
import com.example.roomdemo.localdb.MyDatabase

//This class is use when we need to initialise some of thing at once, this need to added on manifest files application tag name attribute=".MyApp" to work
class MyApp: Application() {
    override fun onCreate() {
        super.onCreate()
        //This call when our app start first time to generate database if not generated
        MyDatabase.getDatabase(this)
    }
}