package com.android1500.interviewapp.api

import com.android1500.interviewapp.room.PostEntity
import retrofit2.http.GET

interface ApiService {

    @GET("posts")
    suspend fun getPosts() : List<PostEntity>


}