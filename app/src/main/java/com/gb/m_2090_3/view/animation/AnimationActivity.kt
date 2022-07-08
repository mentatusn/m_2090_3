package com.gb.m_2090_3.view.animation

import android.graphics.Rect
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.navigation.ui.AppBarConfiguration
import androidx.recyclerview.widget.RecyclerView
import androidx.transition.*
import com.gb.m_2090_3.R
import com.gb.m_2090_3.databinding.ActivityAnimationBinding


class AnimationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAnimationBinding

    var isFlag = true

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)
        binding = ActivityAnimationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val titles: MutableList<String> = ArrayList()
        for (i in 0..4) {
            titles.add("Item $i")
        }



        binding.button.setOnClickListener {
            isFlag = !isFlag
            TransitionManager.beginDelayedTransition(binding.root)
            binding.transitionsContainer.removeAllViews()
            titles.shuffle()
            titles.forEach {
                binding.transitionsContainer.addView(TextView(this).apply {
                    text = it
                    ViewCompat.setTransitionName(this,it) // ЗАДАЛИ "псевдоним"
                })
            }
        }
    }


}