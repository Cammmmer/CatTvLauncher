package com.wuyi.tv.appinfo.manager

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.content.pm.ResolveInfo
import com.wuyi.tv.appinfo.bean.AppInfo
import com.wuyi.tv.common.log.LogUtils


/**
 * @Date: 2025/8/2
 * @Description:
 */
private val TAG = LogUtils.TAG("AppInfoManager")

internal class AppInfoManager {

    /**
     * 获取应用列表数据
     */
    fun getInstalledApplications(context: Context): ArrayList<AppInfo> {
        val list = ArrayList<AppInfo>()
        val pm = context.packageManager
        val intent = Intent()
        intent.action = Intent.ACTION_MAIN
        intent.addCategory(Intent.CATEGORY_LAUNCHER)

        val resolveInfos: MutableList<ResolveInfo> =
            pm.queryIntentActivities(intent, PackageManager.MATCH_ALL)

        for (resolveInfo in resolveInfos) {
            // 包名
            val packageName = resolveInfo.activityInfo.packageName

            // 应用名称
            val label = resolveInfo.loadLabel(pm)
            val appName = label.toString()

            // 应用图标
            val icon = resolveInfo.loadIcon(pm)

            // 对应的启动 Activity 的完整类名（可选，一般用 getLaunchIntentForPackage 更简单）
            val activityName = resolveInfo.activityInfo.name

            AppInfo(
                appName,
                icon,
                ComponentName(packageName, activityName)
            ).apply {
                LogUtils.i(TAG, "loadAppInfo $this")
                list.add(this)
            }
        }

        LogUtils.i(TAG, "loadAppInfo finish, list size: ${list.size}")
        return list
    }
}