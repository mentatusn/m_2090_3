package com.gb.m_2090_3.view.navigation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

import androidx.viewpager2.adapter.FragmentStateAdapter
import com.gb.m_2090_3.view.picture.PictureOfTheDayFragment

class ViewPager2AdapterForEarthFragment(fr: Fragment) : FragmentStateAdapter(fr) {

    private val fragments = arrayOf(PictureOfTheDayFragment.newInstance(), PictureOfTheDayFragment.newInstance(), PictureOfTheDayFragment.newInstance())
    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }

}