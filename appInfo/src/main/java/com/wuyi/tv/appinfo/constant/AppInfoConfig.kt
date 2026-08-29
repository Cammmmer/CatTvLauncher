package com.wuyi.tv.appinfo.constant

import android.content.ComponentName

/**
 * @Author: Cemmmmmer
 * @Date: 2025/8/2
 * @Description:
 */
data class AppInfoConfig(
    val componentName: ComponentName,
    /** 优先级越大，展示在越前面 **/
    val priority: Int,
    val enable: Boolean = true
)

internal val appConfigMap: Map<ComponentName, AppInfoConfig> =
    HashMap<ComponentName, AppInfoConfig>().apply {
        put(AppConstant.bilibili, AppInfoConfig(AppConstant.bilibili, 100))
        put(AppConstant.quark, AppInfoConfig(AppConstant.quark, 99))
    }