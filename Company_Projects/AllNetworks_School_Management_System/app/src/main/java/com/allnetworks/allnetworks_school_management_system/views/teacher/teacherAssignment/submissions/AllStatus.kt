package com.allnetworks.allnetworks_school_management_system.views.teacher.teacherAssignment.submissions

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.allnetworks.allnetworks_school_management_system.R
import com.allnetworks.allnetworks_school_management_system.databinding.FragmentAllStatusBinding
import com.allnetworks.allnetworks_school_management_system.models.testing.AllSubmissionModel
import com.allnetworks.allnetworks_school_management_system.utils.navigateWithId


class AllStatus : Fragment(R.layout.fragment_all_status) {
    private var adapter = SubmissionAdapter()

    lateinit var binding: FragmentAllStatusBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAllStatusBinding.bind(view)

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

        binding.rvAllStatus.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = this@AllStatus.adapter
        }

        adapter.onItemClick = { btnState ->
            if (btnState == "clicked") {
                view.navigateWithId(R.id.action_allSubmission_to_gradeSubmission)
            }
        }
    }
}