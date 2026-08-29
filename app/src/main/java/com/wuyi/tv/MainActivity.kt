package com.wuyi.tv

import android.os.Bundle
import androidx.fragment.app.FragmentActivity

/**
 * Loads [com.wuyi.tv.ui.MainFragment].
 */
class MainActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onBackPressed() {
    }
}