package com.wxl.common.util

import android.widget.Toast
import com.wxl.common.AppContext

/**
 * create file time : 2021/2/23
 * create user : wxl
 * subscribe :
 */
class Toll {
    companion object {
        fun toll(msg: String) {
            Toast.makeText(AppContext.appContext.getApplication(), msg, Toast.LENGTH_SHORT).show()
        }
    }
}