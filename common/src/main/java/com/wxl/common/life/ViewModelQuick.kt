package com.wxl.common.life

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.wxl.common.viewmodel.AbsPresenter
import com.wxl.common.viewmodel.AbsViewModel

/**
 * create file time : 2021/2/23
 * create user : wxl
 * subscribe :
 */
class ViewModelQuick {
    companion object {
        fun <T : AbsPresenter> observer(
            context: AppCompatActivity,
            clazz: Class<T>,
            vararg args: Any
        ): T {
            val t: T = ViewModelProvider(context, ViewModelProvider.NewInstanceFactory()).get(clazz)
            t.onCreated(*args)
            LifecycleManager.manager.addObserver(context.lifecycle, t)
            return t
        }

        fun <T : AbsPresenter> observer(fragment: Fragment, clazz: Class<T>, vararg args: Any): T {
            val t: T =
                ViewModelProvider(fragment, ViewModelProvider.NewInstanceFactory()).get(clazz)
            t.onCreated(*args)
            LifecycleManager.manager.addObserver(fragment.lifecycle, t)
            return t
        }

        fun <T : AbsViewModel> create(
            owner: ViewModelStoreOwner,
            clazz: Class<T>,
            vararg args: Any?
        ): T {
            val t: T = ViewModelProvider(owner, ViewModelProvider.NewInstanceFactory()).get(clazz)
            t.onCreate(*args)
            return t
        }

        fun <T : AbsViewModel> get(owner: ViewModelStoreOwner, clazz: Class<T>): T {
            return ViewModelProvider(owner, ViewModelProvider.NewInstanceFactory()).get(clazz)
        }

        fun <T : AbsPresenter> get(owner: ViewModelStoreOwner, clazz: Class<T>): T {
            return ViewModelProvider(owner, ViewModelProvider.NewInstanceFactory()).get(clazz)
        }
    }
}