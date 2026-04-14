package com.allnetworks.allnetworks_school_management_system.views.teacher.teacherAssignment.createNewAssignment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import com.allnetworks.allnetworks_school_management_system.R
import com.allnetworks.allnetworks_school_management_system.databinding.FragmentNewAssignmentBinding
import com.allnetworks.allnetworks_school_management_system.utils.AppController
import com.allnetworks.allnetworks_school_management_system.views.student.timeTable.TimeTableVM
import dagger.hilt.android.AndroidEntryPoint
import kotlin.getValue

class NewAssignment : Fragment(R.layout.fragment_new_assignment) {
    private lateinit var binding: FragmentNewAssignmentBinding

    private val viewModel by viewModels<NewAssignmentVM>()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentNewAssignmentBinding.bind(view)
        AppController.Companion.navListener?.isLockDrawer(true)
        binding.viewModel = viewModel

    }
}