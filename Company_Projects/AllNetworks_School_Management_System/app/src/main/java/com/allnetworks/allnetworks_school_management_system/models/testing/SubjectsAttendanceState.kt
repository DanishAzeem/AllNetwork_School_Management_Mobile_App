package com.allnetworks.allnetworks_school_management_system.models.testing

import androidx.annotation.Keep

@Keep
data class SubjectsAttendanceState(
    val weeks: String,
    val list: List<LectureDetails>

)

@Keep
data class LectureDetails(
    val date: String,
    val subject: String,
)