package com.allnetworks.allnetworks_school_management_system.views.teacher.teacherAssignment.editAssignment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.allnetworks.allnetworks_school_management_system.R
import com.allnetworks.allnetworks_school_management_system.databinding.FragmentEditAssignmentBinding
import com.allnetworks.allnetworks_school_management_system.utils.AppController
import com.allnetworks.allnetworks_school_management_system.utils.navigateBack
import com.allnetworks.allnetworks_school_management_system.views.student.attendance.AttendanceAdapter
import com.allnetworks.allnetworks_school_management_system.views.teacher.teacherAssignment.allAssignment.AllAssignmentVM
import dagger.hilt.android.AndroidEntryPoint
import kotlin.getValue

@AndroidEntryPoint
class EditAssignment : Fragment(R.layout.fragment_edit_assignment) {
    lateinit var binding: FragmentEditAssignmentBinding
    private var adapter = AttendanceAdapter()
    private val viewModel by viewModels<EditAssignmentVM>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentEditAssignmentBinding.bind(view)
        AppController.Companion.navListener?.isLockDrawer(true)
        binding.viewModel = viewModel

//        binding.etTitle.setText("Chapter 6: Practice Problems")
//        binding.tvDueDate.text = "2026-04-04"
//        binding.etExtendDueDate.setText("2026-04-04")
//        binding.etTotalMarks.setText("100")
//        binding.etDescription.setText("Add instructions or note..")

    }
}