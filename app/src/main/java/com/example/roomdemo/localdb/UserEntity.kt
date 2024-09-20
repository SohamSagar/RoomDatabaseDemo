package com.example.roomdemo.localdb

import androidx.room.Entity
import androidx.room.PrimaryKey

//This is the data class or you can say table so we need to set @Entity annotation also if we need to set primary key we can set it by @PrimaryKey annotation also we can set autoGenerate true or false
@Entity(tableName = "Users")
data class UserEntity (
    @PrimaryKey(autoGenerate = true)
    var id:Int=0,
    var name:String = "",
    var pass:String = ""
)