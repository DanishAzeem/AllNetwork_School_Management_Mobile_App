package com.allnetworks.allnetworks_school_management_system.views.student.assignment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.allnetworks.allnetworks_school_management_system.R
import com.allnetworks.allnetworks_school_management_system.databinding.FragmentUnfinishTaskBinding


class UnfinishTask : Fragment(R.layout.fragment_unfinish_task) {
    private var adapter = AssignmentAdapter()

    lateinit var binding: FragmentUnfinishTaskBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentUnfinishTaskBinding.bind(view)

        val data = arrayListOf("Assignment 1", "Assignment 2", "Assignment 3")

        adapter = AssignmentAdapter(data)

        binding.rvUnFinish.apply {

            layoutManager = LinearLayoutManager(requireContext())
            adapter = this@UnfinishTask.adapter
        }
    }
}