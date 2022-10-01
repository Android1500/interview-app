package com.android1500.interviewapp.ui.screen

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.navArgs
import com.android1500.interviewapp.databinding.FragmentPostBinding
import com.android1500.interviewapp.ui.base.BaseFragment


class PostFragment : BaseFragment<FragmentPostBinding> (FragmentPostBinding::inflate){

    private val args: PostFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.post.text = args.postData.body
    }


}