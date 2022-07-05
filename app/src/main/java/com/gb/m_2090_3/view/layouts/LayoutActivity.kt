package com.gb.m_2090_3.view.layouts

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.gb.m_2090_3.R
import com.gb.m_2090_3.databinding.ActivityLayoutsBinding

class LayoutActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLayoutsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLayoutsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initBottomNavigationView()
    }

    private fun initBottomNavigationView() {

        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.action_constraint -> {
                    navigationTo(ConstraintFragment())
                    true
                }
                R.id.action_coordinator -> {
                    navigationTo(CoordinatorFragment())
                    true
                }
                R.id.action_motion -> {
                    navigationTo(MotionFragment())
                    true
                }
                else -> true
            }
        }
        binding.bottomNavigationView.selectedItemId = R.id.action_motion


    }

    private fun navigationTo(f: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.container, f).commit()
    }

}
