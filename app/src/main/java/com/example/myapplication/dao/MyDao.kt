package com.example.myapplication.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Update

@Dao
interface MyDao {
    @Query("SELECT * FROM Dictionary")
    fun getAllDictionary() : List<User>

    @Query("SELECT * FROM Dictionary WHERE name like :s")
    fun searchByWord(s: String) : List<User>

    @Query("SELECT * FROM Dictionary WHERE isFavorite = :id")
    fun getByIsFavorite( id: Int ) : List<User>

    @Query("SELECT * FROM Dictionary WHERE id = :id ")
    fun getUserById(id: Int)

    @Update
    fun update(user: User)
}