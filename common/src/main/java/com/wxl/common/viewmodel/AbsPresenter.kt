package com.wxl.common.viewmodel

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.ViewModel
import com.wxl.common.AppContext

/**
 * create file time : 2021/2/23
 * create user : wxl
 * subscribe :
 */
abstract class AbsPresenter : ViewModel(), LifecycleObserver {


    /**
     * new after
     */
    abstract fun onCreated(vararg args:Any)


    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    open fun onCreate() {
        AppContext.appContext.getCurrentActivity()
    }


    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    open fun onStart() {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    open fun onResume() {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    open fun onPause() {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    open fun onStop() {

    }


    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    open fun onDestroy(){
    }


    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    open fun onAny(){

    }
}