package com.wxl.common.http

import android.app.Dialog
import android.content.Context
import android.text.TextUtils
import com.alibaba.fastjson.JSONObject
import com.lzy.okgo.callback.Callback
import com.lzy.okgo.model.Progress
import com.lzy.okgo.model.Response
import com.lzy.okgo.request.base.Request
import com.wxl.common.AppContext
import com.wxl.common.util.Toll
import java.lang.Exception
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

/**
 * create file time : 2021/2/22
 * create user : wxl
 * subscribe :
 */
@Suppress("UNCHECKED_CAST", "JAVA_CLASS_ON_COMPANION")
abstract class HttpCallback<T> : Callback<Any> {

    protected open var loadDialog: Dialog? = null

    override fun onSuccess(response: Response<Any>?) {
        response?.body()?.let { success(it as T) }
    }

    override fun onFinish() {
        if (loadDialog != null) {
            if (loadDialog?.isShowing!!) {
                loadDialog?.dismiss()
            }
        }
    }

    override fun downloadProgress(progress: Progress?) {

    }

    override fun uploadProgress(progress: Progress?) {

    }

    override fun convertResponse(response: okhttp3.Response?): T? {

        try {

            response ?: return "" as T

            val data: String = response.body()?.string().toString()

            response.takeIf { it.isSuccessful }?.takeIf { !TextUtils.isEmpty(data) }?.let {

                val type = findConvertType()

                if (TextUtils.equals(type.toString(), String::class.java.name)) {
                    return data as T
                }

                return JSONObject.parseObject(data, type)
            }
        } catch (e: Exception) {
            Toll.toll("数据返回不正确")
            error(e)
        }

        return null
    }

    override fun onError(response: Response<Any>?) {
        response?.exception?.let { error(it) }
    }

    override fun onCacheSuccess(response: Response<Any>?) {

    }

    override fun onStart(request: Request<Any, out Request<Any, Request<*, *>>>?) {
        loadDialog = showLoadDialog(AppContext.appContext.getCurrentActivity())
        loadDialog?:return
        loadDialog.takeIf { !it?.isShowing!! }?.show()
    }


    abstract fun success(data: T)

    open fun error(e: Throwable) {}


    protected open fun showLoadDialog(context: Context?): Dialog? {
        return null
    }

    protected open fun findConvertType(): Type {
        val superclass = javaClass.genericSuperclass
        if (superclass is ParameterizedType) {
            val arrayOfTypes = superclass.actualTypeArguments
            return arrayOfTypes[0]
        }
        return String::class.java
    }

}