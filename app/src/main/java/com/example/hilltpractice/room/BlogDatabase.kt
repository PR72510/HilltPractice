package com.example.hilltpractice.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.hilltpractice.models.Blog

/**
 * Created by PR72510 on 22/7/20.
 */

@Database(entities = [BlogCacheEntity::class], version = 1)
abstract class BlogDatabase: RoomDatabase() {

    abstract fun blogDao(): BlogDao

    companion object{
        val DATABASE_NAME = "blog_db"
    }
}