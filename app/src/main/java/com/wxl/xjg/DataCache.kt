package com.wxl.xjg

/**
 * create file time : 2021/2/24
 * create user : wxl
 * subscribe :
 */

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