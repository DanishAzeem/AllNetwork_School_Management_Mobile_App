package com.allnetworks.allnetworks_school_management_system.views.home

import android.os.SystemClock
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModel
import com.allnetworks.allnetworks_school_management_system.R
import com.allnetworks.allnetworks_school_management_system.utils.AppController
import com.allnetworks.allnetworks_school_management_system.utils.navigateWithId
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject


@HiltViewModel
class HomeVM @Inject constructor(): ViewModel() {

    private var mLastClickTime: Long = 0
    fun onClick(view: View) {
        if (SystemClock.elapsedRealtime() - mLastClickTime < 1000) {
            return
        }
        mLastClickTime = SystemClock.elapsedRealtime()
        when (view.id) {
            R.id.layout_open_drawer -> {
                AppController.navListener?.openDrawer()
            }
//            R.id.fragmentAttendance -> view.navigateWithId(R.id.action_homeFragment_to_attendanceFragment)
//            R.id.lyHome -> view.navigateWithId(R.id.homeFragment)
//            R.id.lyGrades -> view.navigateWithId(R.id.action_homeFragment_to_resultGradesFragment)
//            R.id.lyAssignment -> view.navigateWithId(R.id.action_homeFragment_to_homeWorkAssignmentFragment)
//            R.id.lyAttendance -> view.navigateWithId(R.id.action_homeFragment_to_attendanceFragment)
//            R.id.lyTimeTable -> view.navigateWithId(R.id.action_homeFragment_to_timeTableFragment)
        }

    }
}