package com.android1500.interviewapp.repository

import androidx.room.withTransaction
import com.android1500.interviewapp.api.ApiService
import com.android1500.interviewapp.room.AppDatabase
import com.android1500.interviewapp.room.PostDao
import com.android1500.interviewapp.utils.networkBoundResource
import kotlinx.coroutines.delay
import javax.inject.Inject

class PostRepository @Inject constructor(
      private val database: AppDatabase,
      private val apiService: ApiService,
) {

      private val dao = database.postDao()


      fun getAllPosts() = networkBoundResource (

      query = {
           dao.getAllPosts()
      },
      fetch = {
            delay(2000)
            apiService.getPosts()
      },
      saveFetchResult = {
            database.withTransaction {
                  dao.deleteAll()
                  dao.insertPost(it)
            }

      },

      )










}