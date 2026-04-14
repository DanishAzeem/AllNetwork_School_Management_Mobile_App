package com.allnetworks.allnetworks_school_management_system.models.testing

data class AllAssignmentModel(
    val assignmentDetails: String,
    val classSubject: String,
    val classSection: String,
    val totalTime: String,
    val totalStudents: Int,
    val completedStudents: Int
)