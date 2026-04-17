package com.allnetworks.allnetworks_school_management_system.views.teacher.teacherAssignment.submissions

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.allnetworks.allnetworks_school_management_system.R
import com.allnetworks.allnetworks_school_management_system.databinding.FragmentGradedStatusBinding
import com.allnetworks.allnetworks_school_management_system.databinding.FragmentUnfinishTaskBinding
import com.allnetworks.allnetworks_school_management_system.models.testing.AllSubmissionModel


class GradedStatus : Fragment(R.layout.fragment_graded_status) {
    private var adapter = SubmissionAdapter()

    lateinit var binding: FragmentGradedStatusBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentGradedStatusBinding.bind(view)

        val fakeList = arrayListOf(
            AllSubmissionModel(
                name = "Ali Shehbaz",
                timeAndDate = "Submitted • 19 Apr, 3:20 PM",
                "Pending"
            ),
            AllSubmissionModel(
                name = "Sara Khan",
                timeAndDate = "Submitted • 10 Apr, 9:10 AM",
                "Pending"
            ),
            AllSubmissionModel(
                name = "Omar Malik",
                timeAndDate = "Not submitted yet\n",
                "Missing"
            ),
            AllSubmissionModel(
                name = "Zara Hussain",
                timeAndDate = "Submitted • 10 Apr, 11:00 AM",
                "Pending"
            ),
            AllSubmissionModel(
                name = "Fatima Ali",
                timeAndDate = "Submitted • 8 Apr, 6:45 PM",
                "Graded"
            )
        )

        adapter = SubmissionAdapter(fakeList)

        binding.recyclerView.apply {

            layoutManager = LinearLayoutManager(requireContext())
            adapter = this@GradedStatus.adapter
        }
    }
}