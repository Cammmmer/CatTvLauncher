package com.wuyi.tv.applist.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.wuyi.tv.R
import com.wuyi.tv.appinfo.bean.LauncherItem
import com.wuyi.tv.common.log.LogUtils


/**
 * @Author: Cemmmmmer
 * @Date: 2024/4/19
 * @Description:
 */
internal class AppListViewAdapter : RecyclerView.Adapter<AppListViewAdapter.VH>() {

    companion object {
        private val TAG = LogUtils.TAG("AppListViewAdapter")
    }

    class VH(v: View) : RecyclerView.ViewHolder(v) {
        val titleView: TextView = v.findViewById(R.id.titleView)
        val rootView: View = v.findViewById(R.id.rootView)
    }

    private var data: List<LauncherItem>? = null
    var itemClickListener: ItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, pos: Int): VH {
        return VH(
            LayoutInflater.from(parent.context).inflate(R.layout.item_app_info, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return data?.size ?: 0
    }

    override fun onBindViewHolder(vh: VH, pos: Int) {
        data?.get(pos)?.let { item ->
            //vh.titleView.text = item.getTitle()
            vh.rootView.setBackgroundDrawable(item.getLogo())
            vh.rootView.setOnClickListener {
                itemClickListener?.onItemClick(item)
            }
        }
    }

    fun setData(data: List<LauncherItem>) {
        this.data = data
        notifyDataSetChanged()
    }

    interface ItemClickListener {
        /**
         * 点击
         */
        fun onItemClick(item: LauncherItem)
    }
}