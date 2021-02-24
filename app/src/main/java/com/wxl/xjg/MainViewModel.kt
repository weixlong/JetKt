package com.wxl.xjg

import android.app.Dialog
import android.content.Context
import android.widget.TextView
import androidx.lifecycle.Observer
import com.wxl.common.bean.UserBean
import com.wxl.common.http.HttpCallback
import com.wxl.common.http.OkGoApi
import com.wxl.common.life.LifecycleManager
import com.wxl.common.life.ViewModelQuick
import com.wxl.common.util.Loog
import com.wxl.common.viewmodel.AbsViewModel
import com.wxl.common.wiget.LoadingDialog

/**
 * create file time : 2021/2/23
 * create user : wxl
 * subscribe :
 */
class MainViewModel : AbsViewModel() {

    lateinit var presenter: MainPresenter
    val user = UserBean()

    override fun onCreate(vararg arg: Any?) {
        if (arg.isNotEmpty()) {
            if (arg[0] is MainActivity) {
                presenter = ViewModelQuick.observer(arg[0] as MainActivity, MainPresenter::class.java)
                LifecycleManager.manager.registerLiveData(user,(arg[0] as MainActivity).lifecycle)
            }
            if (arg.size > 1 && arg[1] is TextView) {

                user.observe(arg[0] as MainActivity, Observer {
                    Loog.d("MainViewModel refresh ")
                })

                val textView: TextView = arg[1] as TextView
                textView.setOnClickListener {
                    OkGoApi.api.post((arg[0] as MainActivity).lifecycle)
                    .params("service", "Home.getConfig")
                    .execute(object : HttpCallback<String>() {

                        override fun success(data: String) {
                            user.userName = data
                            LifecycleManager.manager.refreshLiveData(user)
                        }

                        override fun showLoadDialog(context: Context?): Dialog? {
                            return context?.let { LoadingDialog(it) }
                        }

                    })
                }
            }
        }
    }

    
}