package com.example.roomdemo.localdb

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

//This class use for user to do specific kind of module CRUD(Insert,Update,Delete,Select) operations, so we need to use @Dao annotation
@Dao
interface UsersDao{
    //This annotation use for making fun for insert data and in this we set onConflict = replace that mean if data repeated then it will override
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun setUsers(list:List<UserEntity>)

    //This annotation use for raw query like getting all data or on specif condition data
    @Query("select * from Users")
    fun getUsers():List<UserEntity>
}