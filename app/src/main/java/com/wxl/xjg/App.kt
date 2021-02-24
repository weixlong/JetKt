package com.wxl.xjg

import android.app.Application
import com.wxl.common.AppContext

/**
 * create file time : 2021/2/22
 * create user : wxl
 * subscribe :
 */
class App : Application(){
    override fun onCreate() {
        super.onCreate()
        AppContext.appContext.init(this)
    }
}