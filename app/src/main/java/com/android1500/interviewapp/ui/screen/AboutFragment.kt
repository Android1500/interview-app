package com.android1500.interviewapp.ui.screen

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.android1500.interviewapp.BuildConfig
import com.android1500.interviewapp.R
import com.android1500.interviewapp.databinding.FragmentAboutBinding
import com.android1500.interviewapp.ui.base.BaseFragment
import de.Maxr1998.modernpreferences.PreferencesAdapter
import de.Maxr1998.modernpreferences.helpers.*


class AboutFragment : BaseFragment<FragmentAboutBinding>(FragmentAboutBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val screen = screen(context) {
            pref("readme") {
                title = "README"
                summary = "Check the Github repository and the README"
                iconRes = R.drawable.ic_outline_readme_24


            }
            pref("developer"){
                title = "Developer"
                summary = "Android1500"
                iconRes = R.drawable.ic_dev
            }


            pref("version") {
                title = "Version"
                iconRes = R.drawable.ic_outline_info_24
                summary = BuildConfig.VERSION_NAME
            }


        }

        val preferencesAdapter = PreferencesAdapter(screen)
        binding.aboutRcv.layoutManager = LinearLayoutManager(requireContext())
        binding.aboutRcv.adapter = preferencesAdapter
    }


}