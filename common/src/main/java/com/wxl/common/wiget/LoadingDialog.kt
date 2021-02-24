package com.wxl.common.wiget

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import com.wxl.common.R

/**
 * create file time : 2021/2/22
 * create user : wxl
 * subscribe :
 */
class LoadingDialog : Dialog {

    constructor(context: Context) : super(context, R.style.dialog)

    constructor(context: Context, themeResId: Int) : super(context, themeResId)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.loading_layout)
    }
}