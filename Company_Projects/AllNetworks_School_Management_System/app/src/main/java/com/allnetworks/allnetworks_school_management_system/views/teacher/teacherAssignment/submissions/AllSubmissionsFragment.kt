package com.allnetworks.allnetworks_school_management_system.views.teacher.teacherAssignment.submissions

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.allnetworks.allnetworks_school_management_system.R
import com.allnetworks.allnetworks_school_management_system.databinding.FragmentAllSubmissionsBinding
import com.allnetworks.allnetworks_school_management_system.utils.AppController
import com.google.android.material.tabs.TabLayoutMediator

class AllSubmissionsFragment : Fragment(R.layout.fragment_all_submissions) {

    lateinit var binding: FragmentAllSubmissionsBinding
    private val viewModel by viewModels<SubmissionVM>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAllSubmissionsBinding.bind(view)

        binding.viewModel = viewModel
        AppController.navListener?.isLockDrawer(true)

        binding.tabLayout.post {
            for (i in 0 until binding.tabLayout.tabCount) {
                val tab = (binding.tabLayout.getChildAt(0) as ViewGroup).getChildAt(i)
                val params = tab.layoutParams as ViewGroup.MarginLayoutParams
                params.setMargins(6, 0, 6, 0) // adjust gap here
                tab.layoutParams = params
                tab.requestLayout()
            }
        }

        val fragmentList = arrayListOf(
            AllStatus(),
            SubmitStatus(),
            PendingStatus(),
            GradedStatus()
        )

        val adapter = TaskPagerAdapter(
            fragmentList,
            this.childFragmentManager,
            lifecycle
        )
        binding.viewPager.adapter = adapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            when (position) {
                0 -> tab.text = "All"
                1 -> tab.text = "Submitted"
                2 -> tab.text = "Pending"
                3 -> tab.text = "Graded"
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