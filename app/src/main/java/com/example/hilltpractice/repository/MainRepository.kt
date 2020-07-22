package com.example.hilltpractice.repository

import com.example.hilltpractice.common.DataState
import com.example.hilltpractice.models.Blog
import com.example.hilltpractice.retrofit.BlogRetrofit
import com.example.hilltpractice.retrofit.NetworkMapper
import com.example.hilltpractice.room.BlogDao
import com.example.hilltpractice.room.CacheMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 * Created by PR72510 on 22/7/20.
 */
class MainRepository constructor(
    private val blogDao: BlogDao,
    private val blogRetrofit: BlogRetrofit,
    private val cacheMapper: CacheMapper,
    private val networkMapper: NetworkMapper
) {

    suspend fun getBlogs(): Flow<DataState<List<Blog>>> {
        return flow {
            emit(DataState.Loading)
            try {
                val networkBlogs = blogRetrofit.getBlogs()
                val blogList = networkMapper.mapFromEntryList(networkBlogs)
                blogList.forEach { blog ->
                    blogDao.insertBlog(cacheMapper.mapToEntity(blog))
                }
                val cachedBlogs = blogDao.getAllBlogs()
                emit(DataState.Success(cacheMapper.mapFromEntityList(cachedBlogs)))
            } catch (e: Exception) {
                emit(DataState.Error(e))
            }
        }
    }
}