package com.wuyi.tv.common.log

import android.util.Log

/**
 * @Author: Cemmmmmer
 * @Date: 2022/4/1
 * @Description:
 *
 */
object LogUtils {
    private var LOG_TAG_PREFIX = "WTv_"

    const val VERBOSE = 2
    const val DEBUG = 3
    const val INFO = 4
    const val WARN = 5
    const val ERROR = 6
    const val ASSERT = 7
    const val NONE = 8
    private var logLevel = DEBUG

    open class TAG(str: String) {
        private val name: String = "$LOG_TAG_PREFIX$str"
        open fun getName(): String {
            return name
        }
    }

    fun setTagPrefix(prefix: String) {
        LOG_TAG_PREFIX = prefix
    }

    @JvmStatic
    fun v(tag: TAG, msg: String?) {
        msg?.let {
            Log.v(tag.getName(), msg)
        } ?: let {
            Log.v(tag.getName(), "msg is null")
        }
    }

    @JvmStatic
    fun d(tag: TAG, msg: String?) {
        msg?.let {
            Log.d(tag.getName(), msg)
        } ?: let {
            Log.d(tag.getName(), "msg is null")
        }
    }

    @JvmStatic
    fun i(tag: TAG, msg: String?) {
        msg?.let {
            Log.i(tag.getName(), msg)
        } ?: let {
            Log.i(tag.getName(), "msg is null")
        }
    }

    @JvmStatic
    fun w(tag: TAG, msg: String?) {
        msg?.let {
            Log.w(tag.getName(), msg)
        } ?: let {
            Log.w(tag.getName(), "msg is null")
        }
    }

    @JvmStatic
    fun e(tag: TAG, msg: String?) {
        msg?.let {
            Log.e(tag.getName(), msg)
        } ?: let {
            Log.e(tag.getName(), "msg is null")
        }
    }

    @JvmStatic
    fun e(tag: TAG, msg: String?, tr: Throwable?) {
        Log.e(tag.getName(), "$msg \n ${Log.getStackTraceString(tr)}")
    }

    @JvmStatic
    fun println(logLevel: Int, tag: TAG, msg: String?) {
        when (logLevel) {
            VERBOSE -> {
                v(tag, msg)
            }

            DEBUG -> {
                d(tag, msg)
            }

            INFO -> {
                i(tag, msg)
            }

            WARN -> {
                w(tag, msg)
            }

            ERROR -> {
                e(tag, msg)
            }

            else -> {}
        }
    }
}