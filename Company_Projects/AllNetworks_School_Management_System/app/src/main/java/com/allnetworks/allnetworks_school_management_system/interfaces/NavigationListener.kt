package com.allnetworks.allnetworks_school_management_system.interfaces

import androidx.navigation.NavController
import com.allnetworks.allnetworks_school_management_system.MainActivity
import com.allnetworks.allnetworks_school_management_system.MainVM

interface NavigationListener {

    fun isLockDrawer(isLock: Boolean = true)
    fun openDrawer()
    fun setNavHost(): NavController
    fun getMainVm(): MainVM
    fun getMainActivity(): MainActivity
}