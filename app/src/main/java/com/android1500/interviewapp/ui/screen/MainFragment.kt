package com.android1500.interviewapp.ui.screen

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.android1500.interviewapp.adapter.PostAdapter
import com.android1500.interviewapp.databinding.FragmentMainBinding
import com.android1500.interviewapp.model.PostData
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



    private fun setupRecycleView() = with(binding){
            postList.layoutManager = LinearLayoutManager(requireContext())
            postList.adapter = postAdapter
            viewModel.getAllPost.observe(requireActivity()){ result ->
                postAdapter.submitList(result.data)
                when(result){
                    is Resource.Loading  -> {
                        if (!result.data.isNullOrEmpty()){
                            setLoadingState(loading = true, isEmpty = false)
                        }
                    }
                    is Resource.Success -> {
                        setLoadingState(loading = false,false)

                    }
                    is Resource.Error -> {
                        setLoadingState(loading = false,false)
                    }

                }


            }
            postAdapter.onItemClick = {
                val action =  MainFragmentDirections.actionMainFragmentToPostFragment(PostData(it.userId,it.id,it.title,it.body))
                findNavController().navigate(action)
            }


    }

    private fun setLoadingState(loading: Boolean, isEmpty: Boolean) {
        binding.postList.isVisible = !loading && !isEmpty
        binding.loadingData.isVisible = loading && !isEmpty
        binding.empty.isVisible = isEmpty
    }



}