package com.allnetworks.allnetworks_school_management_system.views.home

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import com.allnetworks.allnetworks_school_management_system.R
import com.allnetworks.allnetworks_school_management_system.databinding.FragmentHomeBinding
import com.allnetworks.allnetworks_school_management_system.utils.AppController
import com.allnetworks.allnetworks_school_management_system.utils.AppController.Companion.navListener
import android.view.animation.AnimationUtils
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Home : Fragment(R.layout.fragment_home) {
    private lateinit var binding: FragmentHomeBinding
    private val viewModel by viewModels<HomeVM>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentHomeBinding.bind(view)
        binding.viewModel = viewModel
        navListener?.isLockDrawer(false)

        navListener?.getMainActivity()?.sideDrawerOptionsVisibility()

        val animation = AnimationUtils.loadAnimation(requireContext(), R.anim.rotate)
        binding.welcomeTxt.startAnimation(animation)
    }

}