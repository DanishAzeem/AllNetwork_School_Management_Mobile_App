package com.allnetworks.allnetworks_school_management_system.views.teacher.teacherAssignment.viewAssignment

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.allnetworks.allnetworks_school_management_system.R
import com.allnetworks.allnetworks_school_management_system.utils.navigateBack
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject

@HiltViewModel
class ViewAssignmentVM @Inject constructor(): ViewModel() {

    fun onClick(view: View) {
        when(view.id){
            R.id.ivBack -> {
                navigateBack()
            }
            R.id.tvEditAssignment -> {
                view.findNavController().navigate(R.id.action_viewAssignment_to_editAssignment)
            }
            R.id.tvViewSubmissions -> {
                view.findNavController().navigate(R.id.action_viewAssignment_to_allSubmissions)
            }
        }
    }
}