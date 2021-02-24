package com.wxl.common.http

import android.app.Application
import android.text.TextUtils
import androidx.lifecycle.Lifecycle
import com.lzy.okgo.OkGo
import com.lzy.okgo.cache.CacheMode
import com.lzy.okgo.model.HttpHeaders
import com.lzy.okgo.request.GetRequest
import com.lzy.okgo.request.PostRequest
import com.wxl.common.AppConstant
import com.wxl.common.AppContext
import com.wxl.common.life.LifecycleHandler
import com.wxl.common.util.SpUtil
import java.util.*
import java.util.concurrent.TimeUnit
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

/**
 * create file time : 2021/2/22
 * create user : wxl
 * subscribe :
 */
class OkGoApi {

    private val lifecycles = HashMap<String, ArrayList<String>>()
    private lateinit var baseUrl:String

    companion object {
        val api = OGA.oga
    }

    private object OGA {
        val oga = OkGoApi()
    }

    private constructor() {
        val token = SpUtil.sp.getString("token")
        val userId = SpUtil.sp.getString("userId")
        val headerParams = HttpHeaders()
        headerParams.put("token", token)
        headerParams.put("userId", userId)
        OkGo.getInstance()
            .setCacheMode(CacheMode.NO_CACHE)
            .addCommonHeaders(headerParams)
        OkGo.getInstance().okHttpClient = OkGo.getInstance().okHttpClient.newBuilder()
            .connectTimeout(AppConstant.outTime, TimeUnit.SECONDS)
            .readTimeout(AppConstant.outTime, TimeUnit.SECONDS)
            .writeTimeout(AppConstant.outTime, TimeUnit.SECONDS)
            .build()
    }


    /**
     * 设置基础路径
     */
    fun setBaseUrl(baseUrl:String, app : Application){
        this.baseUrl = baseUrl
        OkGo.getInstance().init(app)
    }

    /**
     * get请求
     * 跟随当前栈顶的activity生命周期结束请求
     */
    fun get(): GetRequest<Any> {
        val activity = AppContext.appContext.getCurrentActivity()
        activity?.let { return getTarget(it.javaClass) }
        return getReq()
    }

    /**
     * post请求
     * 跟随当前栈顶的activity生命周期结束请求
     */
    fun post(): PostRequest<Any> {
        val activity = AppContext.appContext.getCurrentActivity()
        activity?.let { return postTarget(it.javaClass) }
        return postReq()
    }


    /**
     * get请求
     * @param lifecycle 跟随栈顶生命周期结束请求
     */
    private fun getTarget(lifecycle: Class<Any>): GetRequest<Any> {
        val tag = lifecycle.name + System.currentTimeMillis()
        registerLifecycle(lifecycle, tag)
        return OkGo.get<Any>(baseUrl).tag(tag)
    }


    /**
     * get请求
     * @param lifecycle 跟随生命周期ONDESTROY结束请求
     */
    fun get(lifecycle: Lifecycle): GetRequest<Any> {
        val tag = UUID.randomUUID().toString() + System.currentTimeMillis()
        lifecycle.addObserver(LifecycleHandler(tag,3))
        return OkGo.get<Any>(baseUrl).tag(tag)
    }

    /**
     * post请求
     * @param lifecycle 跟随栈顶生命周期结束请求
     */
    private fun postTarget(lifecycle: Class<Any>): PostRequest<Any> {
        val tag = lifecycle.name + System.currentTimeMillis()
        registerLifecycle(lifecycle, tag)
        return OkGo.post<Any>(baseUrl).tag(tag)
    }


    /**
     * post请求
     * @param lifecycle 跟随生命周期ONDESTROY结束请求
     */
    fun post(lifecycle: Lifecycle): PostRequest<Any> {
        val tag = UUID.randomUUID().toString() + System.currentTimeMillis()
        lifecycle.addObserver(LifecycleHandler(tag,3))
        return OkGo.post<Any>(baseUrl).tag(tag)
    }

    /**
     * get 不受生命周期影响
     */
    fun getReq(): GetRequest<Any> {
        return OkGo.get<Any>(baseUrl)
    }

    /**
     * post 不受生命周期影响
     */
    fun postReq(): PostRequest<Any> {
        return OkGo.post(baseUrl)
    }

    /**
     * 注册生命周期监听
     */
    private fun registerLifecycle(targetCls: Class<Any>, tag: String) {
        if (!lifecycles.containsKey(targetCls.name)) {
            lifecycles.put(targetCls.name, ArrayList())
        }
        lifecycles.get(targetCls.name)?.add(tag)
    }


    /**
     * 取消该类(栈顶)下的所有请求
     */
   internal fun cancelTargetApi(targetCls: Class<Any>) {
        if (lifecycles.containsKey(targetCls.name)) {
            lifecycles.remove(targetCls.name)?.let {
                for (s in it) {
                    if (!TextUtils.isEmpty(s)) {
                        OkGo.getInstance().cancelTag(s)
                    }
                }
            }
        }
    }
}