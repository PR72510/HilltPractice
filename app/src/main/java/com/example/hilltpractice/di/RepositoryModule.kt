package com.example.hilltpractice.di

import com.example.hilltpractice.repository.MainRepository
import com.example.hilltpractice.retrofit.BlogRetrofit
import com.example.hilltpractice.retrofit.NetworkMapper
import com.example.hilltpractice.room.BlogDao
import com.example.hilltpractice.room.CacheMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

/**
 * Created by PR72510 on 22/7/20.
 */

@InstallIn(ApplicationComponent::class)
@Module
object RepositoryModule {

    @Singleton
    @Provides
    fun providesRepository(
        blogDao: BlogDao,
        blogRetrofit: BlogRetrofit,
        cacheMapper: CacheMapper,
        networkMapper: NetworkMapper
    ): MainRepository {
        return MainRepository(
            blogDao,
            blogRetrofit,
            cacheMapper,
            networkMapper
        )
    }
}