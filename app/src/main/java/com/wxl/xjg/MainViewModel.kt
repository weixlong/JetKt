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

    override fun onCreate(vararg arg: Any?) {
        if (arg.isNotEmpty()) {

            presenter = ViewModelQuick.observer(arg[0] as MainActivity, MainPresenter::class.java)

            if (arg.size > 1 && arg[1] is TextView) {

                val user = DataCache.get(UserBean::class.java)

                user?.observe(arg[0] as MainActivity, Observer {
                    Loog.d("MainViewModel refresh ")
                })

                val textView: TextView = arg[1] as TextView
                textView.setOnClickListener {
                    OkGoApi.api.post((arg[0] as MainActivity).lifecycle)
                    .params("service", "Home.getConfig")
                    .execute(object : HttpCallback<BaseData<ArrayList<ConfigBean>>>() {

                        override fun success(data: BaseData<ArrayList<ConfigBean>>) {
                            user?.userName = data.data.info.takeIf {
                                !it.isNullOrEmpty()
                            }?.get(0)?.promotionlink
                            user?.let { LifecycleManager.manager.refreshLiveData(user) }
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