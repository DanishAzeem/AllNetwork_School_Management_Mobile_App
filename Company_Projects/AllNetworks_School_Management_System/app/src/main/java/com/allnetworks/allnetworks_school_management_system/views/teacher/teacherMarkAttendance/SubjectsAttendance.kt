package com.allnetworks.allnetworks_school_management_system.views.teacher.teacherMarkAttendance

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.allnetworks.allnetworks_school_management_system.R
import com.allnetworks.allnetworks_school_management_system.databinding.FragmentSubjectsAttendanceBinding
import com.allnetworks.allnetworks_school_management_system.models.ItemVisible
import com.allnetworks.allnetworks_school_management_system.models.testing.LectureDetails
import com.allnetworks.allnetworks_school_management_system.models.testing.SubjectsAttendanceState
import com.allnetworks.allnetworks_school_management_system.utils.AppController
import com.allnetworks.allnetworks_school_management_system.utils.navigateBack

class SubjectsAttendance : Fragment(R.layout.fragment_subjects_attendance) {
    private lateinit var binding: FragmentSubjectsAttendanceBinding

    private val viewModel by viewModels<SubjectsAttendanceVM>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSubjectsAttendanceBinding.bind(view)
        AppController.Companion.navListener?.isLockDrawer(true)
        binding.viewModel = viewModel

        val dummyList = listOf(
            SubjectsAttendanceState(
                weeks = "Monday",
                list = listOf(
                    LectureDetails("9:00 AM - 11:11 AM", "Math"),
                    LectureDetails("10:00 AM - 12:59 AM", "Physics"),
                    LectureDetails("11:00 AM - 11:30 AM", "Biology")
                )
            ),
            SubjectsAttendanceState(
                weeks = "Tuesday",
                list = listOf(
                    LectureDetails("9:00 AM - 11:11 AM", "English"),
                    LectureDetails("10:00 AM - 12:00 AM", "Chemistry")
                )
            ),
            SubjectsAttendanceState(
                weeks = "Wednesday",
                list = listOf(
                    LectureDetails("9:00 AM - 10:00 AM", "Urdu"),
                    LectureDetails("10:00 AM - 10:30 AM", "Islamiat"),
                    LectureDetails("11:00 AM - 11:45 AM", "Computer")
                )
            )
        )
        val adapter = SubjectAttendanceAdapter() { lecture ->
            view.findNavController().navigate(R.id.action_subjectAttendance_to_StudentSummaryAttendance)
        }

        binding.rvSubjectsAttendance.apply {
            layoutManager = LinearLayoutManager(requireContext())
            this.adapter = adapter
        }
        adapter.getData(dummyList)

    }
}