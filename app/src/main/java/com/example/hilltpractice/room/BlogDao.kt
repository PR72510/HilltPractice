package com.example.hilltpractice.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

/**
 * Created by PR72510 on 22/7/20.
 */
@Dao
interface BlogDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBlog(blog: BlogCacheEntity): Long

    @Query("SELECT * FROM blogs")
    suspend fun getAllBlogs(): List<BlogCacheEntity>
}