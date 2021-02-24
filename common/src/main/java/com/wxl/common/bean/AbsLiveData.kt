package com.wxl.common.bean

import androidx.lifecycle.LiveData

/**
 * create file time : 2021/2/23
 * create user : wxl
 * subscribe :
 */
abstract class AbsLiveData<T : Any> : LiveData<T>(){


    fun refresh(t : T){
        value = t
    }

    fun postRefresh(t : T){
        postValue(t)
    }


}