package com.allnetworks.allnetworks_school_management_system.views.parent.parentHomeWork

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.allnetworks.allnetworks_school_management_system.R
import com.allnetworks.allnetworks_school_management_system.databinding.FragmentFeeManagementBinding
import com.allnetworks.allnetworks_school_management_system.databinding.FragmentParentHomeWorkBinding
import com.allnetworks.allnetworks_school_management_system.models.testing.FeeModel
import com.allnetworks.allnetworks_school_management_system.models.testing.ParentHomeWorkModel
import com.allnetworks.allnetworks_school_management_system.utils.AppController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ParentHomeWork : Fragment(R.layout.fragment_parent_home_work) {
    lateinit var binding: FragmentParentHomeWorkBinding
    private val viewModel by viewModels<ParentHomeWorkVM>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentParentHomeWorkBinding.bind(view)
        AppController.navListener?.isLockDrawer(true)
        binding.viewModel = viewModel

        val fakeData = listOf(
            ParentHomeWorkModel(
                "Algebra Worksheet — Ch. 5 ",
                "Mathematics · Mr. Bilal ",
                "Due tomorrow, Apr 23 ",
            ),
            ParentHomeWorkModel(
                "Lab Report — Photosynthesis ",
                "Science · Ms. Hina ",
                "Due Apr 25 ",
            ),
            ParentHomeWorkModel(
                "Essay: My Favourite Season ",
                "English · Mr. Usman ",
                "Due Apr 26 ",
            ),
        )

        val adapter = ParentHomeWorkAdapter()

        binding.rvHomeWork.apply {
            layoutManager = LinearLayoutManager(requireContext())
            this.adapter = adapter
        }
        adapter.getData(fakeData)

    }
}



