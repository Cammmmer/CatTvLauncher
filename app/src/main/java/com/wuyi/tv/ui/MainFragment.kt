package com.wuyi.tv.ui

import android.content.ComponentName
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.wuyi.tv.databinding.FragmentMainBinding

/**
 * Loads a grid of cards with movies to browse.
 */
class MainFragment : Fragment() {
    companion object {
        private const val TAG = "MainFragment"
    }

    private var mRootViewBinding: FragmentMainBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        FragmentMainBinding.inflate(inflater, container, false).apply {
            mRootViewBinding = this
            initView()
            return this.root
        }
    }

    private fun initView() {
        mRootViewBinding?.bilibiliBtn?.setOnClickListener {
            var intent =
                context?.packageManager?.getLeanbackLaunchIntentForPackage("com.xiaodianshi.tv.yst")
            if (intent == null) {
                intent = Intent()
                intent.component = ComponentName(
                    "com.xiaodianshi.tv.yst",
                    "com.xiaodianshi.tv.yst.ui.main.MainActivity"
                )
            }
            intent?.let {
                it.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                context?.startActivity(it)
            }
        }
    }
}