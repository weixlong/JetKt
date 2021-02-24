package com.wxl.common.life

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.lzy.okgo.OkGo

/**
 * create file time : 2021/2/22
 * create user : wxl
 * subscribe :
 */
class LifecycleHandler : LifecycleObserver {

    var tag: String
    var type: Int
    lateinit var liveDataCls: String

    constructor(tag: String, type: Int) {
        this.tag = tag
        this.type = type
    }

    constructor(tag: String, type: Int, liveDataCls: String) {
        this.tag = tag
        this.type = type
        this.liveDataCls = liveDataCls
    }


    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
    }


    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop() {
    }


    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        when (type) {
            1 -> {
                LifecycleManager.manager.removeTargetAllObserver(tag)
            }
            2 -> {
                LifecycleManager.manager.unRegisterLiveDataByTag(liveDataCls, tag)
            }
            3 -> {
                OkGo.getInstance().cancelTag(tag)
            }
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    fun onAny() {

    }
}