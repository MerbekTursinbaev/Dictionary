package com.example.myapplication.dao

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Dictionary")
data class User(
    @PrimaryKey
    var id: Int,
    var name: String,
    var description: String,
    var isFavorite: Int? = 0
)