package com.wxl.xjg

import com.wxl.common.bean.AbsLiveData


/**
 * create file time : 2021/2/27
 * create user : wxl
 * subscribe :
 */
class BaseData<T : Any> : AbsLiveData<T>() {

    var ret: Int = 0
    lateinit var msg: String
    lateinit var data:DATA<T>

    companion object
    class DATA <T> {
        var code: Int = -1
        lateinit var msg : String
        var info: T? = null
        override fun toString(): String {
            return "DATA(code=$code, msg='$msg', info=$info)"
        }
    }

    override fun toString(): String {
        return "BaseData(ret=$ret, msg='$msg', data=$data)"
    }


}