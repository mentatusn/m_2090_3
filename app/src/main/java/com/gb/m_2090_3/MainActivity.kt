package com.gb.m_2090_3

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import com.gb.m_2090_3.databinding.ActivityMainBinding
import com.gb.m_2090_3.view.PictureOfTheDayFragment

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
            supportFragmentManager.beginTransaction().replace(R.id.container,PictureOfTheDayFragment.newInstance()).commit()
        }

    }
}