package com.android1500.interviewapp.room

import androidx.room.*
import kotlinx.coroutines.flow.Flow


@Dao
interface PostDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPost(postEntity: List<PostEntity>)


    @Transaction
    @Query("SELECT * FROM PostEntity")
    fun getAllPosts() : Flow<List<PostEntity>>

    @Query("Delete FROM PostEntity")
    fun deleteAll()



}