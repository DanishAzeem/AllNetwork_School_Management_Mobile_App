package com.allnetworks.allnetworks_school_management_system.views.signUpProcess

import android.os.SystemClock
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModel
import com.allnetworks.allnetworks_school_management_system.R
import com.allnetworks.allnetworks_school_management_system.utils.navigateWithId
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignInVM @Inject constructor(

): ViewModel(){

    private var mLastClickTime:Long = 0
    fun onClick(view: View){
        if (SystemClock.elapsedRealtime() - mLastClickTime < 1000) {
            return
        }
        mLastClickTime = SystemClock.elapsedRealtime()

        when(view.id){
            R.id.loginBtn -> {
                Log.d("Signin Fragment ", "Called")
                view.navigateWithId(R.id.action_signInFragment_to_homeWorkAssignmentFragment)

            }

        }

    }


}