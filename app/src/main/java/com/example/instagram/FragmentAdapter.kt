package com.example.instagram

import ProfileFragment.Fragment1
import ProfileFragment.Fragment2
import ProfileFragment.Fragment3
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class FragmentAdapter(fragmentManager: FragmentManager): FragmentPagerAdapter(fragmentManager) {
    override fun getItem(p0: Int): Fragment {
        when (p0) {
            0 -> return Fragment1()
            1 -> return Fragment2()
            else -> return Fragment3()
        }
    }

    override fun getCount(): Int {
        return 3
    }
}