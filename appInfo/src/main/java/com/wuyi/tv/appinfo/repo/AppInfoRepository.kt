package com.wuyi.tv.appinfo.repo

import com.wuyi.tv.appinfo.bean.AppInfo
import com.wuyi.tv.appinfo.constant.appConfigMap
import com.wuyi.tv.appinfo.manager.AppInfoManager
import com.wuyi.tv.common.global.ContextHolder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * @Author: Cemmmmmer
 * @Date: 2025/8/2
 * @Description:
 */
object AppInfoRepository {

    private val appList = ArrayList<AppInfo>()
    private val appInfoManager = AppInfoManager()

    suspend fun loadAppInfo(): List<AppInfo> = withContext(Dispatchers.IO) {
        if (appList.isNullOrEmpty()) {
            appList.addAll(appInfoManager.getInstalledApplications(ContextHolder.context))

            // 排序 : 基于priority降序排序
            appList.sortWith(compareByDescending {
                appConfigMap[it.componentName]?.priority ?: 0
            })
        }

        return@withContext appList
    }
}