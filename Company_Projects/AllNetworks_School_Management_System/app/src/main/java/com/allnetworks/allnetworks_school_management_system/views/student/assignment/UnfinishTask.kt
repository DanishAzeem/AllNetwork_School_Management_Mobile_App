package com.allnetworks.allnetworks_school_management_system.views.student.assignment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.allnetworks.allnetworks_school_management_system.R
import com.allnetworks.allnetworks_school_management_system.databinding.FragmentUnfinishTaskBinding


class UnfinishTask : Fragment(R.layout.fragment_unfinish_task) {
    lateinit var binding: FragmentUnfinishTaskBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentUnfinishTaskBinding.bind(view)
    }
}