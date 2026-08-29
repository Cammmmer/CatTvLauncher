package com.wuyi.tv.common.utils

import com.wuyi.tv.common.log.LogUtils

/**
 * @Author: Cemmmmmer
 * @Date: 2023/12/19
 * @Description: 版本相关配置
 */
object VersionConfig {
    private val TAG = LogUtils.TAG("VersionConfig")
    private const val UNKNOWN = "unknown"

    var appVersion: String = UNKNOWN

    var branch: String = UNKNOWN

    var carPlatform: String = UNKNOWN


    fun println() {
        LogUtils.e(
            TAG,
            "appVersion:$appVersion, branch:$branch, carPlatform:$carPlatform "
        )
    }
}
