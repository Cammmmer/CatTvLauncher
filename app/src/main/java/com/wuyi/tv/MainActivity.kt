package com.wuyi.tv

import android.os.Bundle
import androidx.fragment.app.FragmentActivity

/**
 * 桌面主入口，经 activity_main.xml 承载壁纸层（WallpaperFragment）与应用列表层（AppListFragment）。
 */
class MainActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onBackPressed() {
    }
}