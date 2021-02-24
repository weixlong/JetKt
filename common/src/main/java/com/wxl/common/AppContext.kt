package com.wxl.common

import android.app.Activity
import android.app.Application
import com.wxl.common.http.OkGoApi
import com.wxl.common.life.ActivityCallback
import com.wxl.common.util.SpUtil

/**
 * create file time : 2021/2/22
 * create user : wxl
 * subscribe :
 */
class AppContext private constructor(){

    private lateinit var context: Application
    private val activityCallback: ActivityCallback = ActivityCallback()

    companion object {
        val appContext = AC.ac
    }

    private object AC {
        val ac = AppContext()
    }

    fun init(context:Application){
        this.context = context
        SpUtil.context = context
        OkGoApi.api.setBaseUrl(AppConstant.baseUrl,context)
        this.context.registerActivityLifecycleCallbacks(activityCallback)
    }

    fun getApplication():Application{
        return context
    }


    fun getCurrentActivity():Activity?{
        return activityCallback.getCurrentActivity()
    }
}