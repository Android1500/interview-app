package com.android1500.interviewapp.viewmodel

import androidx.lifecycle.*
import com.android1500.interviewapp.repositories.PostRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
     postRepository: PostRepository,
    ) : ViewModel() {

    val getAllPost = postRepository.getAllPosts().asLiveData()



}