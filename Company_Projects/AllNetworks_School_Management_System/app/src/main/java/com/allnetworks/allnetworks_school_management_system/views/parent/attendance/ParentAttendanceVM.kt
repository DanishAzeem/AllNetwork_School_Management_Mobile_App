package com.allnetworks.allnetworks_school_management_system.views.parent.attendance

import android.view.View
import androidx.lifecycle.ViewModel
import com.allnetworks.allnetworks_school_management_system.R
import com.allnetworks.allnetworks_school_management_system.utils.navigateBack
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject

@HiltViewModel
class ParentAttendanceVM @Inject constructor(

): ViewModel(){

    fun onClick(view: View) {

        when(view.id) {
            R.id.ivBack -> {
                navigateBack()
            }
        }
    }
}