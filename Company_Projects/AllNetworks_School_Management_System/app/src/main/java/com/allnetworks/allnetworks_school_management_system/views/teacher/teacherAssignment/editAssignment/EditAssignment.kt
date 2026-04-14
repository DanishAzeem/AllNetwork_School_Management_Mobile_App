package com.allnetworks.allnetworks_school_management_system.views.teacher.teacherAssignment.editAssignment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.allnetworks.allnetworks_school_management_system.R
import com.allnetworks.allnetworks_school_management_system.databinding.FragmentEditAssignmentBinding
import com.allnetworks.allnetworks_school_management_system.utils.AppController
import com.allnetworks.allnetworks_school_management_system.utils.navigateBack
import com.allnetworks.allnetworks_school_management_system.views.student.attendance.AttendanceAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EditAssignment : Fragment(R.layout.fragment_edit_assignment) {
    lateinit var binding: FragmentEditAssignmentBinding
    private var adapter = AttendanceAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentEditAssignmentBinding.bind(view)
        AppController.Companion.navListener?.isLockDrawer(true)

        val data = arrayListOf("Monday", "Tuesday", "Wednesday")
        adapter = AttendanceAdapter(data)
        binding.rvAttendance.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = this@EditAssignment.adapter
        }
        binding.ivBack.setOnClickListener {
            navigateBack()
        }
    }
}