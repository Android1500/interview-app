package com.android1500.interviewapp.ui.screen

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.android1500.interviewapp.adapter.PostAdapter
import com.android1500.interviewapp.databinding.FragmentMainBinding
import com.android1500.interviewapp.model.PostData
import com.android1500.interviewapp.room.PostEntity
import com.android1500.interviewapp.ui.base.BaseFragment
import com.android1500.interviewapp.utils.Resource
import com.android1500.interviewapp.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainFragment : BaseFragment<FragmentMainBinding>(FragmentMainBinding::inflate) {

    private val viewModel by viewModels<MainViewModel>()
    private val postAdapter: PostAdapter = PostAdapter()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecycleView()

    }

    private fun setupRecycleView() = with(binding.postList){
            layoutManager = LinearLayoutManager(requireContext())
            adapter = postAdapter
            viewModel.getAllPost.observe(requireActivity()){ result ->
                postAdapter.submitList(result.data)
                handleUiState(result)
            }
            postAdapter.onItemClick = {
                val action =  MainFragmentDirections.actionMainFragmentToPostFragment(PostData(it.userId,it.id,it.title,it.body))
                findNavController().navigate(action)
            }


    }

    private fun handleUiState(loading: Resource<List<PostEntity>>){
        setLoadingState(loading is Resource.Loading , (
                loading is Resource.Loading && loading.data.isNullOrEmpty()
                ))
    }

    private fun setLoadingState(loading: Boolean, isEmpty: Boolean) {
        binding.postList.isVisible = !loading && !isEmpty
        binding.loadingData.isVisible = loading && !isEmpty
        binding.empty.isVisible = isEmpty
    }



}