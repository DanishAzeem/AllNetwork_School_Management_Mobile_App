package com.allnetworks.allnetworks_school_management_system.models.testing

import androidx.annotation.Keep

@Keep
class StudentAttendanceListModel(
    val name: String,
    val rollNo: String,
    var isPresent: Boolean?,
)