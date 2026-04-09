package com.allnetworks.allnetworks_school_management_system.views.student.assignment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.allnetworks.allnetworks_school_management_system.R
import com.allnetworks.allnetworks_school_management_system.databinding.FragmentFinishTaskBinding
import com.allnetworks.allnetworks_school_management_system.views.student.timeTable.TimeTableAdapter


class FinishTask : Fragment(R.layout.fragment_finish_task) {

    private var adapter = AssignmentAdapter()

    lateinit var binding: FragmentFinishTaskBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFinishTaskBinding.bind(view)

        val data = arrayListOf("Assignment 1", "Assignment 2", "Assignment 3")

        adapter = AssignmentAdapter(data)

        binding.rvFinish.apply {

            layoutManager = LinearLayoutManager(requireContext())
            adapter = this@FinishTask.adapter
        }

    }

}