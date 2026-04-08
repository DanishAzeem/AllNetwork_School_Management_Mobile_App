package com.allnetworks.allnetworks_school_management_system.utils

import android.app.Activity
import android.os.Bundle
import android.view.View
import androidx.navigation.findNavController
import kotlin.text.get

fun View.navigateWithId(id: Int, bundle: Bundle? = null) = try {
    ValidatorUtils.hideSoftKeyboard(AppController.context?.get() as Activity)
    this.findNavController().navigate(id, bundle)
} catch (e: Exception) {
    e.printStackTrace()
}

fun navigateBack() = try {
    (AppController.context?.get() as Activity).let {
        ValidatorUtils.hideSoftKeyboard(it)
        it.onBackPressed()
    }
} catch (e: Exception) {
    e.printStackTrace()
}
