package com.gb.m_2090_3.view.animation

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.navigation.ui.AppBarConfiguration
import androidx.transition.ChangeBounds
import androidx.transition.Fade
import androidx.transition.TransitionManager
import androidx.transition.TransitionSet
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
            myAutoTransition.ordering = TransitionSet.ORDERING_TOGETHER
            val fade = Fade()
            val changeBounds = ChangeBounds()
            myAutoTransition.addTransition(fade)
            myAutoTransition.addTransition(changeBounds)
            TransitionManager.beginDelayedTransition(binding.transitionsContainer,myAutoTransition)
            binding.text.visibility = if(isFlag) View.VISIBLE else {View.GONE}
        }

    }
}