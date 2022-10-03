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
        exitTransition = getMaterialSharedAxis(requireContext(), true)
        enterTransition = getMaterialSharedAxis(requireContext(), true)
        returnTransition = getMaterialSharedAxis(requireContext(), false)
        reenterTransition = getMaterialSharedAxis(requireContext(), false)
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


    private fun getMaterialSharedAxis(context: Context, forward: Boolean): MaterialSharedAxis {
        return MaterialSharedAxis(MaterialSharedAxis.X, forward).apply {
            (primaryAnimatorProvider as SlideDistanceProvider).slideDistance =
                context.resources.getDimension(R.dimen.shared_axis_x_slide_distance).roundToInt()
            duration = 450L
            (secondaryAnimatorProvider as FadeThroughProvider).progressThreshold = 0.22f
            interpolator = AnimationUtils.loadInterpolator(context, R.anim.fast_out_extra_slow_in)
        }
    }
}