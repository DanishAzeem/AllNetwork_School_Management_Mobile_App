package com.allnetworks.allnetworks_school_management_system.views.teacher.teacherMarkAttendance.studentSummary

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.allnetworks.allnetworks_school_management_system.R
import com.allnetworks.allnetworks_school_management_system.databinding.FragmentNewAssignmentBinding
import com.allnetworks.allnetworks_school_management_system.databinding.FragmentSubjectsAttendanceBinding
import com.allnetworks.allnetworks_school_management_system.utils.AppController
import com.allnetworks.allnetworks_school_management_system.utils.dpToPx
import com.allnetworks.allnetworks_school_management_system.views.teacher.teacherAssignment.createNewAssignment.NewAssignmentVM

class StudentSummary : Fragment(R.layout.fragment_subjects_attendance) {
    private lateinit var binding: FragmentSubjectsAttendanceBinding

//    private val viewModel by viewModels<NewAssignmentVM>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSubjectsAttendanceBinding.bind(view)
        AppController.Companion.navListener?.isLockDrawer(true)
//        binding.viewModel = viewModel




    }
}