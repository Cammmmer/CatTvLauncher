package com.wuyi.tv.common.global

import android.app.Application
import androidx.annotation.ColorRes
import androidx.annotation.DimenRes
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat

/**
 * @Author: Cemmmmmer
 * @Date: 2022/4/1
 * @Description:
 *
 */
object ContextHolder {
    lateinit var context: Application

    fun getDimension(@DimenRes id: Int): Float {
        return context.resources.getDimension(id)
    }

    fun getString(@StringRes resId: Int, vararg formatArgs: Any?): String {
        return context.resources.getString(resId, *formatArgs)
    }

    fun getColor(@ColorRes resId: Int): Int {
        return ContextCompat.getColor(context, resId)
    }
}