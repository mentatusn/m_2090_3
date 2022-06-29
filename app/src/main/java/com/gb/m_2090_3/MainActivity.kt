package com.gb.m_2090_3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.navigation.ui.AppBarConfiguration
import com.gb.m_2090_3.databinding.ActivityMainBinding
import com.gb.m_2090_3.view.picture.PictureOfTheDayFragment

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)

        //setTheme(R.style.MyRedTheme)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        if(savedInstanceState==null){
            supportFragmentManager.beginTransaction().replace(R.id.container,
                PictureOfTheDayFragment.newInstance()).commit()
        }

    }
}