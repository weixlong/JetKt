package com.wxl.common.life

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import com.wxl.common.bean.AbsLiveData
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

/**
 * create file time : 2021/2/22
 * create user : wxl
 * subscribe :
 */
@Suppress("UNCHECKED_CAST")
class LifecycleManager private constructor() {

    private val lifecycleObserverCache = HashMap<String, ArrayList<LifecycleObserver>>()
    private val lifecycleCache = HashMap<String, Lifecycle>()
    private val liveDataCache = HashMap<String, HashMap<String, AbsLiveData<Any>>>()

    companion object {
        val manager = LM.lm
    }

    private object LM {
        val lm = LifecycleManager()
    }


    /**
     * 注册一个生命周期
     */
    @Synchronized
    fun addObserver(lifecycle: Lifecycle, observer: LifecycleObserver) {
        synchronized(lifecycle) {
            lifecycle.addObserver(observer)
            val tag: String = lifecycle.javaClass.canonicalName?.toString() + UUID.randomUUID() + System.currentTimeMillis()
            lifecycle.addObserver(LifecycleHandler(tag, 1))
            lifecycleCache[tag] = lifecycle
            if (!lifecycleObserverCache.containsKey(tag)) {
                lifecycleObserverCache[tag] = ArrayList()
            }
            lifecycleObserverCache[tag]?.add(observer)
        }
    }


    /**
     * 移除对应tag的所有注册
     */
    internal fun removeTargetAllObserver(tag: String) {
        if (lifecycleObserverCache.containsKey(tag)) {
            val observers: ArrayList<LifecycleObserver> =
                lifecycleObserverCache.remove(tag)!!
            val lifecycle: Lifecycle = lifecycleCache.remove(tag)!!
            for (observer in observers) {
                lifecycle.removeObserver(observer)
            }
            observers.clear()
        }
    }


    /**
     * 注册一个自动解除注册的LiveData
     * 如一个类在项目中频繁被使用，建议只注册一次，并做全局缓存从缓存中拿，减少运行内存开支
     */
    @Synchronized
    fun <T : AbsLiveData<T>> registerLiveData(t: T, lifecycle: Lifecycle) {
        synchronized(t) {
            val tag: String = t.javaClass.name + UUID.randomUUID() + System.currentTimeMillis()
            lifecycle.addObserver(LifecycleHandler(tag, 2, t.javaClass.name))
            if (!liveDataCache.containsKey(t.javaClass.name)) {
                liveDataCache[t.javaClass.name] = HashMap()
            }
            liveDataCache[t.javaClass.name]?.let { it.put(tag, t as AbsLiveData<Any>) }
        }
    }

    /**
     * 同步刷新数据
     */
    fun <T : AbsLiveData<T>> refreshLiveData(t: T) {
        liveDataCache[t.javaClass.name]?.let {
            it.let {
                val iterator = it.entries.iterator()
                while (iterator.hasNext()) {
                    val next = iterator.next()
                    next.value.refresh(t)
                }
            }
        }
    }


    /**
     * 异步刷新数据
     */
    fun <T : AbsLiveData<T>> postLiveData(t: T) {
        liveDataCache[t.javaClass.name]?.let {
            it.let {
                val iterator = it.entries.iterator()
                while (iterator.hasNext()) {
                    val next = iterator.next()
                    next.value.postRefresh(t)
                }
            }
        }
    }


    /**
     * 移除dataCls 关联的所有的 LiveData
     * @param dataCls 关联的所有的dataCls
     */
    fun unRegisterLiveData(dataCls: String) {
        if (liveDataCache.containsKey(dataCls)) {
            liveDataCache.remove(dataCls)
        }
    }

    /**
     * 跟随生命周期解绑一个LiveData
     */
    internal fun unRegisterLiveDataByTag(dataCls: String, tag: String) {
        if (liveDataCache.containsKey(dataCls)) {
            val map = liveDataCache[dataCls]
            map?.let {
                if (map.containsKey(tag)) {
                    map.remove(tag)
                    if (map.isNullOrEmpty()) {
                        liveDataCache.remove(dataCls)
                    }
                }
            }
        }
    }

    /**
     * 清除所有LiveData注册
     */
    fun clearRegisterLiveData() {
        liveDataCache.clear()
    }


}
