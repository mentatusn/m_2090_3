package com.gb.m_2090_3.view.animation

import android.os.Bundle
import android.view.Gravity
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.navigation.ui.AppBarConfiguration
import androidx.transition.*
import com.gb.m_2090_3.databinding.ActivityAnimationBinding

class AnimationActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityAnimationBinding

    var isFlag = false

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)
        binding = ActivityAnimationBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.button.setOnClickListener {
            isFlag = !isFlag
            val myAutoTransition = TransitionSet()
            //myAutoTransition.ordering = TransitionSet.ORDERING_TOGETHER
            myAutoTransition.ordering = TransitionSet.ORDERING_SEQUENTIAL
            val fade = Slide(Gravity.END)
            fade.duration = 1000L
            val changeBounds = ChangeBounds()
            changeBounds.duration  = 2000L
            myAutoTransition.addTransition(changeBounds)
            myAutoTransition.addTransition(fade)
            TransitionManager.beginDelayedTransition(binding.transitionsContainer,myAutoTransition)
            binding.text.visibility = if(isFlag) View.VISIBLE else {View.GONE}
        }

    }
}