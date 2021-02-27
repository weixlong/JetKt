package com.wxl.xjg

/**
 * create file time : 2021/2/24
 * create user : wxl
 * subscribe :
 */

@Suppress("UNCHECKED_CAST")
class DataCache {

    companion object{
        private val cache = HashMap<Class<Any>,Any>()

        fun put(data:Any){
            cache[data.javaClass] = data
        }

        fun <T : Any> get(cls:Class<T>) :T?{
            return cache[cls as Class<Any>] as T
        }
    }
}