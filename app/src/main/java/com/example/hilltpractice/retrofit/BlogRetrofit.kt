package com.example.hilltpractice.retrofit

import retrofit2.http.GET

/**
 * Created by PR72510 on 22/7/20.
 */
interface BlogRetrofit {

    @GET("blogs")
    suspend fun getBlogs(): List<BlogNetworkEntity>
}