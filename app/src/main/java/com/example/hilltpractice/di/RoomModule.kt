package com.example.hilltpractice.di

import android.content.Context
import androidx.room.Room
import com.example.hilltpractice.room.BlogDao
import com.example.hilltpractice.room.BlogDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

/**
 * Created by PR72510 on 22/7/20.
 */

@InstallIn(ApplicationComponent::class)
@Module
object RoomModule {

    @Singleton
    @Provides
    fun providesBlogDatabase(@ApplicationContext context: Context): BlogDatabase {
        return Room.databaseBuilder(
            context,
            BlogDatabase::class.java,
            BlogDatabase.DATABASE_NAME
        ).fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun providesBlogDao(blogDatabase: BlogDatabase): BlogDao{
        return blogDatabase.blogDao()
    }
}