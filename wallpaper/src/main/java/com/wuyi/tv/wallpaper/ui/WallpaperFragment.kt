package com.wuyi.tv.wallpaper.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.wuyi.tv.wallpaper.databinding.FragmentWallpaperBinding

/**
 * @Author: Cemmmmmer
 * @Date: 2025/7/26
 * @Description:
 */
class WallpaperFragment : Fragment() {
    private var rootViewBinding: FragmentWallpaperBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        FragmentWallpaperBinding.inflate(inflater, container, false).apply {
            rootViewBinding = this
            initView()
            return this.root
        }
    }
    private fun initView() {
    }
}