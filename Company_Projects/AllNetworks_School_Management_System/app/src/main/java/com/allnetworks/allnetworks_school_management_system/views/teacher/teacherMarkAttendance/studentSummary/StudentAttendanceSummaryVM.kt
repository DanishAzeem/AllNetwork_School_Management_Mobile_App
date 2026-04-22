package com.allnetworks.allnetworks_school_management_system.views.teacher.teacherMarkAttendance.studentSummary

import android.view.View
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import com.allnetworks.allnetworks_school_management_system.R
import com.allnetworks.allnetworks_school_management_system.utils.DateTimeUtil
import com.allnetworks.allnetworks_school_management_system.utils.navigateBack
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject

@HiltViewModel
class StudentAttendanceSummaryVM @Inject constructor(): ViewModel() {

    fun onClick(view: View) {
        when(view.id){
            R.id.ivBack -> {
                navigateBack()
            }
            R.id.createNewAttendance -> {
                view.findNavController().navigate(R.id.action_studentSummaryAttendance_to_StudentCreateAttendanceList)
            }
        }
    }
}