package com.allnetworks.allnetworks_school_management_system.views.teacher.teacherMarkAttendance

import android.view.View
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.allnetworks.allnetworks_school_management_system.R
import com.allnetworks.allnetworks_school_management_system.utils.DateTimeUtil
import com.allnetworks.allnetworks_school_management_system.utils.navigateBack
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject

@HiltViewModel
class SubjectsAttendanceVM @Inject constructor(): ViewModel() {

    var dueDate: ObservableField<String> = ObservableField("")

    fun onClick(view: View) {
        when(view.id){
            R.id.ivBack -> {
                navigateBack()
            }
            R.id.publishAssignmentBtn -> {
                view.findNavController().navigate(R.id.action_editAssignment_to_allAssignment)
            }
            R.id.et_extendDueDate -> {
                DateTimeUtil.showDatePicker(allowPastDates = false, allowFutureDates = true) {
                    dueDate.set(it)
                }
            }
        }
    }
}