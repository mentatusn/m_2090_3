package com.gb.m_2090_3.view.navigation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class ViewPagerAdapter(fragmentManager: FragmentManager) :
    FragmentStatePagerAdapter(fragmentManager) {

    private val fragments = arrayOf(EarthFragment(), MarsFragment(), SystemFragment())
    override fun getCount(): Int {
        return fragments.size
    }

    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }

    /* override fun getPageTitle(position: Int): CharSequence? {
         return fragments[position].toString()
     }*/

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> {
                "Земля"
            }
            1 -> {
                "Марс"
            }
            2 -> {
                "Система"
            }
            else -> "Земля"
        }
    }
}