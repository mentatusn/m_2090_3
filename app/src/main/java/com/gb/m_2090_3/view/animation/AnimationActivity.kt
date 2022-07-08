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
import androidx.appcompat.app.AppCompatActivity
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

        binding.button.setOnClickListener {
            isFlag = !isFlag
            val params = it.layoutParams as FrameLayout.LayoutParams

            val changeBounds = ChangeBounds()
            changeBounds.duration = 2000L
            changeBounds.setPathMotion(ArcMotion())
            TransitionManager.beginDelayedTransition(binding.root,changeBounds)
            if (isFlag) {
                params.gravity = Gravity.TOP or Gravity.START
            } else {
                params.gravity = Gravity.BOTTOM or Gravity.END
            }
            binding.button.layoutParams = params
        }
    }


}