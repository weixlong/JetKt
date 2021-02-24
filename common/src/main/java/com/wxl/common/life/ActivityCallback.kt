package com.wxl.common.life

import android.app.Activity
import android.app.Application
import android.os.Bundle
import com.wxl.common.http.OkGoApi
import java.lang.ref.WeakReference

/**
 * create file time : 2021/2/22
 * create user : wxl
 * subscribe :
 */
class ActivityCallback : Application.ActivityLifecycleCallbacks {

    private lateinit var wka: WeakReference<Activity>

    override fun onActivityPaused(activity: Activity) {

    }

    override fun onActivityStarted(activity: Activity) {

    }

    override fun onActivityDestroyed(activity: Activity) {
        OkGoApi.api.cancelTargetApi(activity.javaClass)
    }

    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {

    }

    override fun onActivityStopped(activity: Activity) {

    }

    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
        wka = WeakReference(activity)
    }

    override fun onActivityResumed(activity: Activity) {
        wka = WeakReference(activity)
    }


    fun getCurrentActivity(): Activity? {
        return wka.get()
    }
}
