package com.example.myapplication.dao

import androidx.room.Dao
import androidx.room.Query

@Dao
interface MyDao {
    @Query("SELECT * FROM Dictionary")
    fun getAllDictionary() : List<User>
}