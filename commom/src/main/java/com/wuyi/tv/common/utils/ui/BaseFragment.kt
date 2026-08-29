package com.wuyi.tv.common.utils.ui

import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import com.wuyi.tv.common.log.LogUtils

/**
 * @Author: Cemmmmmer
 * @Date: 2022/4/1
 * @Description: Visibility fragment, combine [onResume() onHiddenChanged()] to onVisible()
 *
 */
open class BaseFragment(
    @LayoutRes contentLayoutId: Int = 0
) : Fragment(), IFragmentVisibility {

    companion object {
        private val TAG = LogUtils.TAG("BaseFragment")
    }

    // True if the fragment is visible to the user.
    private var mIsFragmentVisible = false

    // True if the fragment is visible to the user for the first time.
    private var mIsFragmentVisibleFirst = true

    override fun onStart() {
        super.onStart()
        LogUtils.i(TAG, "onStart :$this")
    }

    override fun onResume() {
        super.onResume()
        LogUtils.i(TAG, "onResume :$this")
        determineFragmentVisible()
    }

    override fun onPause() {
        super.onPause()
        LogUtils.i(TAG, "onPause :$this")
        determineFragmentInvisible()
    }

    override fun onStop() {
        super.onStop()
        LogUtils.i(TAG, "onStop :$this")
    }

    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        LogUtils.i(TAG, "onHiddenChanged :$this, hidden:$hidden")
        if (hidden) {
            determineFragmentInvisible()
        } else {
            determineFragmentVisible()
        }
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        LogUtils.i(TAG, "setUserVisibleHint :$this, isVisibleToUser:$isVisibleToUser")
        if (isVisibleToUser) {
            determineFragmentVisible()
        } else {
            determineFragmentInvisible()
        }
    }

    override fun isVisibleToUser(): Boolean = mIsFragmentVisible
    override fun isVisibleFirst(): Boolean = mIsFragmentVisibleFirst

    private fun determineFragmentVisible() {
        val parent = parentFragment
        if (parent != null && parent is BaseFragment && !parent.isVisibleToUser()) {
            // Parent Fragment is invisible, child fragment must be invisible.
            return
        }

        if (isResumed && !isHidden && userVisibleHint && !mIsFragmentVisible) {
            mIsFragmentVisible = true
            onVisible()
            if (mIsFragmentVisibleFirst) {
                mIsFragmentVisibleFirst = false
                onVisibleFirst()
            } else {
                onVisibleExceptFirst()
            }
            determineChildFragmentVisible()
        }
    }

    private fun determineFragmentInvisible() {
        if (mIsFragmentVisible) {
            mIsFragmentVisible = false
            onInvisible()
            determineChildFragmentInvisible()
        }
    }

    private fun determineChildFragmentVisible() {
        childFragmentManager.fragments.forEach {
            if (it is BaseFragment) {
                it.determineFragmentVisible()
            }
        }
    }

    private fun determineChildFragmentInvisible() {
        childFragmentManager.fragments.forEach {
            if (it is BaseFragment) {
                it.determineFragmentInvisible()
            }
        }
    }
}

internal interface IFragmentVisibility {

    /**
     * Called when the fragment is visible.
     */
    fun onVisible() {
        //do nothing
    }

    /**
     * Called when the Fragment is not visible.
     */
    fun onInvisible() {
        //do nothing
    }

    /**
     * Called when the fragment is visible for the first time.
     */
    fun onVisibleFirst() {
        //do nothing
    }

    /**
     * Called when the fragment is visible except first time.
     */
    fun onVisibleExceptFirst() {
        //do nothing
    }

    /**
     * Return true if the fragment is currently visible to the user.
     */
    fun isVisibleToUser(): Boolean

    /**
     * Return true if the fragment is visible for the first time.
     *
     * @return
     */
    fun isVisibleFirst(): Boolean
}