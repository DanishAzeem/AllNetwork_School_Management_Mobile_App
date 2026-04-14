package com.allnetworks.allnetworks_school_management_system.utils

import android.app.Activity
import android.app.Application
import android.content.Context
import android.os.Bundle
import android.util.Log
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



}
