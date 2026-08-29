package com.wuyi.tv.common.log

/**
 * @Author: Cemmmmmer
 * @Date: 2025/8/2
 * @Description:
 */
private val ClickEvent = LogUtils.TAG("event_onClick")
private val NullException = LogUtils.TAG("event_nullException")

object LogEvent {
    /**
     * 点击事件记录
     */
    fun onClick(log: String) {
        LogUtils.i(ClickEvent, log)
    }

    /**
     * 非常规空异常
     */
    fun nullException(log: String) {
        LogUtils.i(ClickEvent, log)
    }
}