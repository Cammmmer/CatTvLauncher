package com.wuyi.tv.applist.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.wuyi.tv.appinfo.bean.LauncherItem
import com.wuyi.tv.applist.adapter.AppListViewAdapter
import com.wuyi.tv.common.utils.ui.BaseFragment
import com.wuyi.tv.databinding.FragmentAppListBinding
import com.wuyi.tv.applist.viewmodel.AppInfoViewMode
import com.wuyi.tv.common.log.LogEvent

/**
 * @Date: 2025/8/2
 * @Description:
 */
class AppListFragment : BaseFragment() {
    companion object {
        private const val TAG = "AppListFragment"
    }

    private lateinit var rootViewBinding: FragmentAppListBinding
    private var appListViewAdapter = AppListViewAdapter()

    private val appInfoModel: AppInfoViewMode by lazy {
        ViewModelProvider(requireActivity()).get(AppInfoViewMode::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        FragmentAppListBinding.inflate(inflater, container, false).apply {
            rootViewBinding = this
            initView()
            initData()
            return this.root
        }
    }

    private fun initView() {
        initAppList()
        appInfoModel.appInfoResult.observe(viewLifecycleOwner) { data ->
            appListViewAdapter.setData(data)
        }
    }

    private fun initData() {
        appInfoModel.loadAppInfo()
    }

    private fun initAppList() {
        rootViewBinding.appList.apply {
            val linearLayoutManager = LinearLayoutManager(context)
            linearLayoutManager.orientation = RecyclerView.HORIZONTAL
            this.layoutManager = linearLayoutManager
            this.adapter = appListViewAdapter
            appListViewAdapter.itemClickListener = object : AppListViewAdapter.ItemClickListener {
                override fun onItemClick(item: LauncherItem) {
                    LogEvent.onClick("AppListItem :${item}")
                    item.onClick(context)
                }
            }
        }
    }
}