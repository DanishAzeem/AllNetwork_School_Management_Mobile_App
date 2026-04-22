package com.allnetworks.allnetworks_school_management_system.models

import androidx.annotation.Keep

@Keep
data class ItemVisible(
    var viewAttendance: Boolean = false,
    var addAttendance: Boolean = false,
    var submission: Boolean = false,
) {
    fun getResult(fragmentName: String): Boolean {
        viewAttendance = false
        addAttendance = false
        submission = false
        return when (fragmentName) {
            "view attendance" -> viewAttendance = true
            "add attendance" -> addAttendance = true
            "submission" -> submission = true
            else -> false
        } as Boolean
    }
}
