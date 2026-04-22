package com.allnetworks.allnetworks_school_management_system.views.teacher.teacherMarkAttendance.createAttendance

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.allnetworks.allnetworks_school_management_system.R
import com.allnetworks.allnetworks_school_management_system.databinding.FragmentCreateAttendanceBinding
import com.allnetworks.allnetworks_school_management_system.models.testing.StudentAttendanceListModel
import com.allnetworks.allnetworks_school_management_system.models.testing.StudentAttendanceSummaryModel
import com.allnetworks.allnetworks_school_management_system.utils.AppController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CreateAttendance : Fragment(R.layout.fragment_create_attendance) {
    private lateinit var binding: FragmentCreateAttendanceBinding

    private val viewModel by viewModels<CreateAttendanceVM>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCreateAttendanceBinding.bind(view)
        AppController.Companion.navListener?.isLockDrawer(true)
        binding.viewModel = viewModel

        val fakeData = listOf(
            StudentAttendanceListModel(
                "Ali Khan",
                "Roll #16",
                null
            ),
            StudentAttendanceListModel(
                "Haider Ali",
                "Roll #12",
                null
            ),
            StudentAttendanceListModel(
                "Younas Raza",
                "Roll #11",
                null
            ),
            StudentAttendanceListModel(
                "Sadiq Javed",
                "Roll #22",
                null
            ),
            StudentAttendanceListModel(
                "Hamza Ali",
                "Roll #2",
                null
            ),
        )
        val adapter = CreateAttendanceAdapter()

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            this.adapter = adapter
        }
        binding.recyclerView.itemAnimator = null

        adapter.getData(fakeData)
    }
}