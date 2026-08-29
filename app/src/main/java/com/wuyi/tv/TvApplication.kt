package com.wuyi.tv

import android.app.Application
import com.wuyi.tv.common.global.ContextHolder
import com.wuyi.tv.common.log.LogUtils

/**
 * @Author: Cemmmmmer
 * @Date: 2025/7/31
 * @Description:
 */
class TvApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initBasics()
    }

    /**
     * 初始化基础配置
     */
    private fun initBasics() {
        ContextHolder.context = this
        LogUtils.setTagPrefix("WTv_")
    }
}