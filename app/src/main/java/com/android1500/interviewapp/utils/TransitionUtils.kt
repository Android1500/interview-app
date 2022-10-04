package com.android1500.interviewapp.utils

import android.content.Context
import android.view.animation.AnimationUtils
import com.android1500.interviewapp.R
import com.google.android.material.transition.FadeThroughProvider
import com.google.android.material.transition.MaterialSharedAxis
import com.google.android.material.transition.SlideDistanceProvider
import kotlin.math.roundToInt

object TransitionUtils {

  fun getMaterialSharedAxis(context: Context, forward: Boolean): MaterialSharedAxis {
        return MaterialSharedAxis(MaterialSharedAxis.X, forward).apply {
            (primaryAnimatorProvider as SlideDistanceProvider).slideDistance =
                context.resources.getDimension(R.dimen.shared_axis_x_slide_distance).roundToInt()
            duration = 450L
            (secondaryAnimatorProvider as FadeThroughProvider).progressThreshold = 0.22f
            interpolator = AnimationUtils.loadInterpolator(context, R.anim.fast_out_extra_slow_in)
        }
    }
}