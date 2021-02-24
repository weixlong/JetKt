package com.wxl.common.util

import android.util.Log


/**
 * create file time : 2021/2/23
 * create user : wxl
 * subscribe :
 */
class Loog {

    companion object {

        val TAG: String = Loog::class.java.simpleName

        val segmentSize:Int = 3 * 1024

        fun i(msg: String) {
            var logMsg:String = msg
            val length: Int = logMsg.length
            if (length <= segmentSize) { // 长度小于等于限制直接打印
                Log.i(TAG, logMsg)
            } else {
                while (logMsg.length > segmentSize) { // 循环分段打印日志
                    val logContent = logMsg.substring(0, segmentSize)
                    logMsg = logMsg.replace(logContent, "")
                    Log.i(TAG, logContent)
                }
                Log.i(TAG, logMsg) // 打印剩余日志
            }
        }

        fun d(msg: String) {
            var logMsg:String = msg
            val length: Int = logMsg.length
            if (length <= segmentSize) { // 长度小于等于限制直接打印
                Log.d(TAG, logMsg)
            } else {
                while (logMsg.length > segmentSize) { // 循环分段打印日志
                    val logContent = logMsg.substring(0, segmentSize)
                    logMsg = logMsg.replace(logContent, "")
                    Log.d(TAG, logContent)
                }
                Log.d(TAG, logMsg) // 打印剩余日志
            }
        }

        fun e(msg: String) {
            var logMsg:String = msg
            val length: Int = logMsg.length
            if (length <= segmentSize) { // 长度小于等于限制直接打印
                Log.e(TAG, logMsg)
            } else {
                while (logMsg.length > segmentSize) { // 循环分段打印日志
                    val logContent = logMsg.substring(0, segmentSize)
                    logMsg = logMsg.replace(logContent, "")
                    Log.e(TAG, logContent)
                }
                Log.e(TAG, logMsg) // 打印剩余日志
            }
        }

        fun v(msg: String) {
            var logMsg:String = msg
            val length: Int = logMsg.length
            if (length <= segmentSize) { // 长度小于等于限制直接打印
                Log.v(TAG, logMsg)
            } else {
                while (logMsg.length > segmentSize) { // 循环分段打印日志
                    val logContent = logMsg.substring(0, segmentSize)
                    logMsg = logMsg.replace(logContent, "")
                    Log.v(TAG, logContent)
                }
                Log.v(TAG, logMsg) // 打印剩余日志
            }
        }

    }
}