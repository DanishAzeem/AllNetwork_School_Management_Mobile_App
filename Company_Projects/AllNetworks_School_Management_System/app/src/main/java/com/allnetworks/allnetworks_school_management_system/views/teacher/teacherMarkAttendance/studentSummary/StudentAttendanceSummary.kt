package com.allnetworks.allnetworks_school_management_system.views.teacher.teacherMarkAttendance.studentSummary

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.allnetworks.allnetworks_school_management_system.R
import com.allnetworks.allnetworks_school_management_system.databinding.FragmentStudentAttendanceSummaryBinding
import com.allnetworks.allnetworks_school_management_system.models.testing.StudentAttendanceSummaryModel
import com.allnetworks.allnetworks_school_management_system.utils.AppController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StudentAttendanceSummary : Fragment(R.layout.fragment_student_attendance_summary) {
    private lateinit var binding: FragmentStudentAttendanceSummaryBinding

    private val viewModel by viewModels<StudentAttendanceSummaryVM>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentStudentAttendanceSummaryBinding.bind(view)
        AppController.Companion.navListener?.isLockDrawer(true)
        binding.viewModel = viewModel

        val fakeData = listOf(
            StudentAttendanceSummaryModel(
                "Ali Khan",
                16,
                18,
            ),
            StudentAttendanceSummaryModel(
                "Haider Ali",
                17,
                18,
            ),
            StudentAttendanceSummaryModel(
                "Younas Raza",
                15,
                18,
            ),
            StudentAttendanceSummaryModel(
                "Sadiq Javed",
                10,
                18,
            ),
            StudentAttendanceSummaryModel(
                "Hamza Ali",
                12,
                18,
            ),
        )
        val adapter = StudentAttendanceSummaryAdapter()

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            this.adapter = adapter
        }

        adapter.getData(fakeData)
    }
}