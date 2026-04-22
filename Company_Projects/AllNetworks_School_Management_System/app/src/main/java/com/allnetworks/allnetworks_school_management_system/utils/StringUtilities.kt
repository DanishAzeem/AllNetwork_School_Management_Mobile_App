package com.allnetworks.allnetworks_school_management_system.utils


fun getInitials(name: String): String {
    val words = name.trim().split(" ")
    return when {
        words.size >= 2 -> "${words[0].first()}${words[1].first()}".uppercase()
        words.size == 1 -> words[0].take(2).uppercase()
        else -> "?"
    }
}