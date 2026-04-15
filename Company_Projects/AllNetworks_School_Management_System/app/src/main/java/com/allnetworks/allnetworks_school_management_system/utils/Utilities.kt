package com.allnetworks.allnetworks_school_management_system.utils

import android.content.Context
import android.content.res.Resources


fun Int.dpToPx(): Int {
    return (this * Resources.getSystem().displayMetrics.density).toInt()
}

fun Context.dpToPx(dp: Int): Int {
    return (dp * resources.displayMetrics.density).toInt()
}