package com.android1500.interviewapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContentProviderCompat
import androidx.core.content.res.ResourcesCompat
import com.android1500.interviewapp.databinding.FragmentContainerBinding
import com.android1500.interviewapp.ui.base.BaseFragment


class ContainerFragment : BaseFragment<FragmentContainerBinding>(FragmentContainerBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}