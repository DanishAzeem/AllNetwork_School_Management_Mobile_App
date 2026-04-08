package com.allnetworks.allnetworks_school_management_system.views.student.assignment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.allnetworks.allnetworks_school_management_system.R
import com.allnetworks.allnetworks_school_management_system.databinding.FragmentHomeWorkAssignmentBinding
import com.allnetworks.allnetworks_school_management_system.views.signUpProcess.SignInVM
import com.google.android.material.tabs.TabLayoutMediator
import kotlin.getValue

class AssignmentFragment : Fragment(R.layout.fragment_home_work_assignment) {

    lateinit var binding: FragmentHomeWorkAssignmentBinding
    private val viewModel by viewModels<AssignmentVM>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentHomeWorkAssignmentBinding.bind(view)
        binding.viewModel = viewModel

        val fragmentList = arrayListOf(
            FinishTask(),
            UnfinishTask()
        )

        val adapter = TaskPagerAdapter(
            fragmentList,
            this.childFragmentManager,
            lifecycle
        )
        binding.viewPager.adapter = adapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            when (position) {
                0 -> tab.text = "Unfinished"
                1 -> tab.text = "Finished"
            }
        }.attach()
    }

    class TaskPagerAdapter(
        private val fragments: ArrayList<Fragment>,
        fragmentManager: FragmentManager,
        lifecycle: Lifecycle,
    ) : FragmentStateAdapter(fragmentManager, lifecycle) {
        override fun getItemCount(): Int {
            return fragments.size
        }
        override fun createFragment(position: Int): Fragment {
            return fragments[position]
        }
    }

}