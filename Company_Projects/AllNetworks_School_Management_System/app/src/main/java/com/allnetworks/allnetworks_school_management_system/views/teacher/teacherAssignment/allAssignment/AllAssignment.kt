package com.allnetworks.allnetworks_school_management_system.views.teacher.teacherAssignment.allAssignment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.allnetworks.allnetworks_school_management_system.R
import com.allnetworks.allnetworks_school_management_system.databinding.FragmentAllAssignmentBinding
import com.allnetworks.allnetworks_school_management_system.models.testing.AllAssignmentModel
import com.allnetworks.allnetworks_school_management_system.utils.AppController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AllAssignment : Fragment(R.layout.fragment_all_assignment) {

    private lateinit var binding: FragmentAllAssignmentBinding

    private var adapter = AllAssignmentAdapter()

    private val viewModel by viewModels<AllAssignmentVM>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentAllAssignmentBinding.bind(view)
        binding.viewModel = viewModel
        AppController.navListener?.isLockDrawer(true)
        val fakeList = arrayListOf(
            AllAssignmentModel(
                "Math Homework Chapter 1",
                "Math",
                "10",
                "12 Mar",
                50,
                30
            ),
            AllAssignmentModel(
                "Science Project",
                "Science",
                "9B",
                "4 Apr",
                40,
                25
            ),
            AllAssignmentModel(
                "English Essay Writing",
                "English",
                "8C",
                "5 May",
                35,
                20
            ),
            AllAssignmentModel(
                "Computer Lab Task",
                "Computer",
                "7A",
                "12 June",
                45,
                35
            ),
            AllAssignmentModel(
                "Physics Numerical",
                "Physics",
                "10B",
                "1 Oct",
                60,
                50
            )
        )
        adapter = AllAssignmentAdapter(fakeList)
        binding.rvAllAssignments.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = this@AllAssignment.adapter
        }

        adapter.onItemClick = { btnState ->
            if(btnState == "clicked") {
                findNavController().navigate(R.id.action_allAssignment_to_viewAssignment)
            }
        }
    }

}