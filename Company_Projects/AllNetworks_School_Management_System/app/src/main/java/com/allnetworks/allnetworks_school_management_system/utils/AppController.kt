package com.allnetworks.allnetworks_school_management_system.utils

import android.app.Activity
import android.app.Application
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.databinding.ObservableField
import com.allnetworks.allnetworks_school_management_system.interfaces.NavigationListener
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import java.lang.ref.WeakReference

@HiltAndroidApp
class AppController: Application() {
    private var currentActivity: Activity? = null
    companion object {

        var context: WeakReference<Context>? = null
        var navListener: NavigationListener? = null


        @JvmStatic
        fun getAppControllerContext(): Context {
            return context?.get()!!
        }
        var userRole: ObservableField<String> = ObservableField("")
    }

    override fun onCreate() {
        super.onCreate()

        registerActivityLifecycleCallbacks(object : ActivityLifecycleCallbacks {
            override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {}
            override fun onActivityStarted(activity: Activity) {
                currentActivity = activity
            }

            override fun onActivityResumed(activity: Activity) {
                currentActivity = activity
            }

            override fun onActivityPaused(activity: Activity) {
                if (currentActivity == activity) currentActivity = null
            }

            override fun onActivityStopped(activity: Activity) {
                if (currentActivity == activity) currentActivity = null
            }

            override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {}
            override fun onActivityDestroyed(activity: Activity) {
                if (currentActivity == activity) currentActivity = null
            }
        })
    }

    override fun onTerminate() {
        super.onTerminate()
        CoroutineScope(Dispatchers.IO).cancel() // Cancel all coroutines
    }

    private fun setupActivityListener() {
        registerActivityLifecycleCallbacks(object : ActivityLifecycleCallbacks {
            override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
                // bypassProd
//                activity.window.setFlags(
//                    WindowManager.LayoutParams.FLAG_SECURE,
//                    WindowManager.LayoutParams.FLAG_SECURE
//                )
            }

            override fun onActivityStarted(p0: Activity) = Unit

            override fun onActivityResumed(p0: Activity) = Unit

            override fun onActivityPaused(p0: Activity) = Unit

            override fun onActivityStopped(p0: Activity) = Unit

            override fun onActivitySaveInstanceState(p0: Activity, p1: Bundle) = Unit

            override fun onActivityDestroyed(p0: Activity) = Unit

        })
    }




}
