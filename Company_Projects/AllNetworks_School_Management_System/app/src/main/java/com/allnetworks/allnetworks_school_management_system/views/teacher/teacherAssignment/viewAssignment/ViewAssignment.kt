package com.allnetworks.allnetworks_school_management_system.views.teacher.teacherAssignment.viewAssignment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.allnetworks.allnetworks_school_management_system.R
import com.allnetworks.allnetworks_school_management_system.databinding.FragmentViewAssignmentBinding
import com.allnetworks.allnetworks_school_management_system.utils.AppController
import com.allnetworks.allnetworks_school_management_system.utils.navigateBack
import com.allnetworks.allnetworks_school_management_system.views.student.attendance.AttendanceAdapter
import com.allnetworks.allnetworks_school_management_system.views.teacher.teacherAssignment.editAssignment.EditAssignmentVM
import dagger.hilt.android.AndroidEntryPoint
import kotlin.getValue

@AndroidEntryPoint
class ViewAssignment : Fragment(R.layout.fragment_view_assignment) {
    lateinit var binding: FragmentViewAssignmentBinding
    private var adapter = AttendanceAdapter()
    private val viewModel by viewModels<ViewAssignmentVM>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentViewAssignmentBinding.bind(view)
        AppController.Companion.navListener?.isLockDrawer(true)
        binding.viewModel = viewModel

        val data = arrayListOf("Monday", "Tuesday", "Wednesday")
        adapter = AttendanceAdapter(data)

        binding.ivBack.setOnClickListener {
            navigateBack()
        }
    }
}