package com.android1500.interviewapp.ui.screen

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
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
                onClick {
                    openLink("https://github.com/Android1500/interview-app/blob/master/README.md")
                    return@onClick true
                }

            }
            pref("developer") {
                title = "Developer"
                summary = "Android1500"
                iconRes = R.drawable.ic_dev
                onClick{
                    openLink("https://github.com/Android1500")
                    return@onClick true
                }
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

    private fun openLink(url : String){
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }


}