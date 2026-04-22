package com.allnetworks.allnetworks_school_management_system.models.testing

import androidx.annotation.Keep

@Keep
class StudentAttendanceSummaryModel(
    val name: String,
    val attendance: Int,
    val total_attendance_count: Int,

)