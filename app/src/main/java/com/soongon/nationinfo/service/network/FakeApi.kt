package com.soongon.nationinfo.service.network

import com.soongon.nationinfo.model.Post
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface FakeApi {

    @GET("posts")
    fun getPosts(
        //@Query("query") query: String
    ): Call<List<Post>>
}