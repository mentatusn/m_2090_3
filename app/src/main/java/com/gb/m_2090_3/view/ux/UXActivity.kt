package com.gb.m_2090_3.view.ux

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.gb.m_2090_3.R
import com.gb.m_2090_3.databinding.ActivityUxBinding
import com.gb.m_2090_3.view.ux.ButtonUXFragment
import com.gb.m_2090_3.view.ux.TextUXFragment
import com.gb.m_2090_3.view.ux.TutorialButtonUXFragment

class UXActivity : AppCompatActivity() {
    lateinit var binding: ActivityUxBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.MyNewTheme)
        binding = ActivityUxBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bottomNavigationViewUX.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.fragment_ux_text -> {
                    navigateTo(TextUXFragment())
                }
                R.id.fragment_ux_button -> {
                    navigateTo(ButtonUXFragment())
                }
                R.id.fragment_ux_tutorial -> {
                    navigateTo(TutorialButtonUXFragment.newInstance())
                }
            }
            true
        }

        binding.bottomNavigationViewUX.selectedItemId = R.id.fragment_ux_button
    }

    private fun navigateTo(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.container, fragment).commit()
    }

}