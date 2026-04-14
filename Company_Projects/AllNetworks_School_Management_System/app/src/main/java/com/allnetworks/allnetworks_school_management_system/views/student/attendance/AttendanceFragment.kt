package com.allnetworks.allnetworks_school_management_system.views.student.attendance

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.allnetworks.allnetworks_school_management_system.R
import com.allnetworks.allnetworks_school_management_system.databinding.FragmentAttendanceBinding
import com.allnetworks.allnetworks_school_management_system.utils.AppController
import com.allnetworks.allnetworks_school_management_system.utils.navigateBack
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AttendanceFragment : Fragment(R.layout.fragment_attendance) {
    lateinit var binding: FragmentAttendanceBinding
    private var adapter = AttendanceAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAttendanceBinding.bind(view)
        AppController.navListener?.isLockDrawer(true)

        val data = arrayListOf("Monday", "Tuesday", "Wednesday")
        adapter = AttendanceAdapter(data)
        binding.rvAttendance.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = this@AttendanceFragment.adapter
        }
        binding.ivBack.setOnClickListener {
            navigateBack()
        }
    }
}