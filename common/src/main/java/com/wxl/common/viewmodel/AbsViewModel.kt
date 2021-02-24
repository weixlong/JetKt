package com.wxl.common.viewmodel

import androidx.lifecycle.ViewModel

/**
 * create file time : 2021/2/23
 * create user : wxl
 * subscribe :
 */
abstract class AbsViewModel : ViewModel(){


    /**
     * new after
     */
    abstract fun onCreate(vararg arg:Any?)
}