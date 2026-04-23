package com.allnetworks.allnetworks_school_management_system.views.parent.attendance

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.allnetworks.allnetworks_school_management_system.R
import com.allnetworks.allnetworks_school_management_system.databinding.FragmentFeeManagementBinding
import com.allnetworks.allnetworks_school_management_system.databinding.FragmentParentAttendanceBinding
import com.allnetworks.allnetworks_school_management_system.models.testing.FeeModel
import com.allnetworks.allnetworks_school_management_system.utils.AppController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ParentAttendance : Fragment(R.layout.fragment_parent_attendance) {
    lateinit var binding: FragmentParentAttendanceBinding
    private val viewModel by viewModels<ParentAttendanceVM>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentParentAttendanceBinding.bind(view)
        AppController.navListener?.isLockDrawer(true)
        binding.viewModel = viewModel


    }
}



