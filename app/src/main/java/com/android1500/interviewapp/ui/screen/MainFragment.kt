package com.android1500.interviewapp.ui.screen

import android.content.Context
import android.content.Intent
import android.net.NetworkCapabilities
import android.os.Bundle
import android.provider.Settings
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.android1500.interviewapp.adapter.PostAdapter
import com.android1500.interviewapp.databinding.FragmentMainBinding
import com.android1500.interviewapp.model.PostData
import com.android1500.interviewapp.ui.base.BaseFragment
import com.android1500.interviewapp.utils.ext.isNetworkConnected
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainFragment : BaseFragment<FragmentMainBinding>(FragmentMainBinding::inflate) {

    private val viewModel by viewModels<MainViewModel>()
    private lateinit var postAdapter: PostAdapter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecycle()
        binding.permissionAccesbility.setOnClickListener {
            startActivity(Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS))

        }


    }

    private fun setupRecycle() = with(binding){
        if (requireContext().isNetworkConnected()){
            postAdapter = PostAdapter()
            postList.layoutManager = LinearLayoutManager(requireContext())
            postList.adapter = postAdapter
            viewModel.getAllPost.observe(requireActivity()){ result ->
                postAdapter.submitList(result.data)
            }

            postAdapter.onItemClick = {
                val action =  MainFragmentDirections.actionMainFragmentToPostFragment(PostData(it.userId,it.id,it.title,it.body))
                findNavController().navigate(action)
            }
        }else {
            binding.error.visibility = View.VISIBLE
        }

    }








}