package com.wuyi.tv.appinfo.bean

import android.content.Context
import android.graphics.drawable.Drawable

/**
 * @Date: 2025/8/2
 * @Description:
 */
interface LauncherItem {

    fun getTitle(): String

    fun getLogo(): Drawable

    fun onClick(context: Context)
}