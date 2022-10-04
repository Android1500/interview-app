package com.android1500.interviewapp.ui.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.android1500.interviewapp.R
import com.android1500.interviewapp.utils.TransitionUtils
import com.google.android.material.transition.FadeThroughProvider
import com.google.android.material.transition.MaterialSharedAxis
import com.google.android.material.transition.SlideDistanceProvider
import kotlin.math.roundToInt

abstract class BaseFragment<T : ViewBinding>(private val inflate: (LayoutInflater, ViewGroup?, Boolean) -> T) :
    Fragment() {

    private var _binding: T? = null
    protected val binding: T
        get() = _binding ?: throw RuntimeException("Cannot access binding before onCreateView or after onDestroyView")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        exitTransition = TransitionUtils.getMaterialSharedAxis(requireContext(), true)
        enterTransition = TransitionUtils.getMaterialSharedAxis(requireContext(), true)
        returnTransition = TransitionUtils.getMaterialSharedAxis(requireContext(), false)
        reenterTransition = TransitionUtils.getMaterialSharedAxis(requireContext(), false)
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        _binding = inflate(inflater, container, false)
        return _binding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



}