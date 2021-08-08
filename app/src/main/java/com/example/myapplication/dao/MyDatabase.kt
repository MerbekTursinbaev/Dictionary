package com.example.myapplication.dao

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myapplication.fragment.ViewFragment

@Database(entities = [User::class], version = 1)
abstract class MyDatabase : RoomDatabase() {

    companion object {
        lateinit var INSTANCE : MyDatabase
        fun getInstance(context: ViewFragment) : MyDatabase {
            if (!::INSTANCE.isInitialized) {
                INSTANCE = Room.databaseBuilder(
                    context, // kt: (16, 21): Type mismatch: inferred type is ViewFragment but Context was expected
                    MyDatabase::class.java,"dictionary-database"
                )
                    .allowMainThreadQueries()
                    .createFromAsset("Dictionary.db")
                    .build()
            }
            return INSTANCE
        }
    }
    abstract fun dictionaryDao() : MyDao
}