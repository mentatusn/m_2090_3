package com.gb.m_2090_3.view.navigation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gb.m_2090_3.databinding.ActivityViewPagerBinding

class ViewPagerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityViewPagerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewPagerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.viewPager.adapter = ViewPagerAdapter(supportFragmentManager)
        //binding.viewPager2.adapter
    }
}
