package com.allnetworks.allnetworks_school_management_system.views.teacher.teacherTimeTable

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.allnetworks.allnetworks_school_management_system.R
import com.allnetworks.allnetworks_school_management_system.databinding.FragmentTeacherClassesBinding
import com.allnetworks.allnetworks_school_management_system.utils.AppController
import com.allnetworks.allnetworks_school_management_system.utils.navigateBack

class TeacherClasses : Fragment(R.layout.fragment_teacher_classes) {

    var adapter = TeacherClassesAdapter()

    lateinit var binding: FragmentTeacherClassesBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentTeacherClassesBinding.bind(view)

        AppController.navListener?.isLockDrawer(true)

        val data = arrayListOf("1", "2", "3")

        adapter = TeacherClassesAdapter(data)

        binding.rv1.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = this@TeacherClasses.adapter
        }
        binding.ivBack.setOnClickListener {
            navigateBack()
        }

    }

}