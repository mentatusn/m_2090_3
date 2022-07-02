package com.gb.m_2090_3.view.navigation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class ViewPagerAdapter(fragmentManager: FragmentManager): FragmentStatePagerAdapter(fragmentManager) {

    private val fragments = arrayOf(EarthFragment(),MarsFragment(),SystemFragment())
    override fun getCount(): Int {
        return fragments.size
    }
    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }
}