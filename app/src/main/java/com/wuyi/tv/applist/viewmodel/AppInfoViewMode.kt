package com.wuyi.tv.applist.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wuyi.tv.appinfo.bean.AppInfo
import com.wuyi.tv.appinfo.repo.AppInfoRepository
import kotlinx.coroutines.launch

/**
 * @Date: 2025/8/2
 * @Description:
 */
class AppInfoViewMode : ViewModel() {

    // Task列表数据更新结果
    private val _appInfoResult = MutableLiveData<List<AppInfo>>()
    val appInfoResult = _appInfoResult

    fun loadAppInfo() {
        viewModelScope.launch {
            appInfoResult.value = (AppInfoRepository.loadAppInfo())
        }
    }
}