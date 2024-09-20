package com.example.roomdemo.localdb

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import java.util.concurrent.Executors

//This is database class here we use @Database annotation and specif entitles means tables, database version number and generate database if not exist
@Database(entities = [UserEntity::class], exportSchema = false, version = 1)
abstract class MyDatabase:RoomDatabase() {
    abstract fun getUsersDao():UsersDao

    companion object{
        var db:MyDatabase? = null

        fun getDatabase(context: Context){
            if (db == null) {
                //here in the name parameter we can set database name
                db = Room.databaseBuilder(context.applicationContext,MyDatabase::class.java,"MyFirstDatabase")
                        .allowMainThreadQueries()
                        .setQueryCallback({ sqlQuery, bindArgs ->
                            Log.d("@QUERY", "SQL Query: $sqlQuery SQL Args: $bindArgs")
                        }, Executors.newSingleThreadExecutor()).fallbackToDestructiveMigration().build()
            }
        }
    }
}