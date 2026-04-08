package com.allnetworks.allnetworks_school_management_system.views.student.timeTable

import android.os.SystemClock
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModel
import com.allnetworks.allnetworks_school_management_system.R
import com.allnetworks.allnetworks_school_management_system.utils.navigateBack
import com.allnetworks.allnetworks_school_management_system.utils.navigateWithId
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TimeTableVM @Inject constructor(

): ViewModel() {
    private var mLastClickTime: Long = 0
    fun onClick(view: View) {
        if (SystemClock.elapsedRealtime() - mLastClickTime < 1000) {
            return
        }
        mLastClickTime = SystemClock.elapsedRealtime()

        when (view.id) {
            R.id.layout_back -> {
                navigateBack()
            }

        }

    }
}

