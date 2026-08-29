package com.wuyi.tv.appinfo.bean

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.graphics.drawable.Drawable
import com.wuyi.tv.common.log.LogEvent

/**
 * @Date: 2025/8/2
 * @Description:
 */
class AppInfo(
    private val name: String,
    private val icon: Drawable,
    val componentName: ComponentName
) : LauncherItem {
    override fun getTitle(): String {
        return name
    }

    override fun getLogo(): Drawable {
        return icon
    }

    override fun onClick(context: Context) {
        val launchIntent: Intent? =
            context.packageManager.getLaunchIntentForPackage(componentName.packageName)
        launchIntent?.let {
            context.startActivity(it)
        } ?: let {
            LogEvent.nullException("launchIntent is null")
        }
    }

    override fun toString(): String {
        return "title:${getTitle()}, componentName:${componentName}"
    }
}