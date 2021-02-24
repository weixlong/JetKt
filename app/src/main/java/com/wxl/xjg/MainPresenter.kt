package com.wxl.xjg

import com.wxl.common.life.LifecycleManager
import com.wxl.common.bean.UserBean
import com.wxl.common.util.Loog
import com.wxl.common.viewmodel.AbsPresenter

/**
 * create file time : 2021/2/22
 * create user : wxl
 * subscribe :
 */
class MainPresenter : AbsPresenter() {

    private lateinit var user: UserBean

    override fun onCreated(vararg args: Any) {
        user = UserBean()
    }


    override fun onCreate() {
        Loog.e("MainPresenter onCreate")
    }


    override fun onPause() {
        Loog.e("MainPresenter onPause")
    }

    fun refreshData(){
        user.userName = "MainPresenter"
        LifecycleManager.manager.refreshLiveData(user)
    }
}