package com.allnetworks.allnetworks_school_management_system

import android.os.SystemClock
import android.view.View
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.allnetworks.allnetworks_school_management_system.utils.AppController
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainVM @Inject constructor(

) : ViewModel() {
    lateinit var navController: NavController
    private var mLastClickTime: Long = 0

    fun onClick(view: View) {
        if (SystemClock.elapsedRealtime() - mLastClickTime < 1000) {
            return
        }
        mLastClickTime = SystemClock.elapsedRealtime()
        when (view.id) {
            R.id.lyHome -> AppController.navListener?.openDrawer()
            R.id.lyGrades -> navController.navigate(R.id.ResultGradesFragment)
            R.id.lyAssignment -> navController.navigate(R.id.HomeWorkAssignment)
            R.id.lyTimeTable -> navController.navigate(R.id.TimeTableFragment)
            R.id.lyAttendance -> navController.navigate(R.id.AttendanceFragment)
            R.id.lyMyClasses -> navController.navigate(R.id.MyClasses)
            R.id.lyAllAssignment -> navController.navigate(R.id.AllAssignment)

        }

    }
}