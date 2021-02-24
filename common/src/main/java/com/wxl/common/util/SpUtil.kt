package com.wxl.common.util

import android.content.Context
import android.content.SharedPreferences

/**
 * create file time : 2021/2/22
 * create user : wxl
 * subscribe :
 */
class SpUtil {

    lateinit var spXml: SharedPreferences

    private object SU {
        val spUtil = SpUtil()
    }

    companion object {
        val sp = SU.spUtil
        lateinit var context: Context
    }

    private constructor()

    private fun initSpXml() {
        spXml = context.applicationContext.getSharedPreferences(
            context.packageName,
            Context.MODE_PRIVATE
        )
    }

    fun put(key: String, value: String) {
        initSpXml()
        spXml.edit().putString(key, value).apply()
    }


    fun getString(key: String): String {
        initSpXml()
        val value = spXml.getString(key, "")
        return value.toString()
    }
}