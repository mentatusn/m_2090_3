package com.gb.m_2090_3.view.animation

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import android.graphics.Rect
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
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

    var isFlag = false
    var duration = 1000L

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)
        binding = ActivityAnimationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val titles: MutableList<String> = ArrayList()
        for (i in 0..4) {
            titles.add("Item $i")
        }



        binding.fab.setOnClickListener {
            isFlag = !isFlag
            if(isFlag){
                ObjectAnimator.ofFloat(binding.plusImageView,View.ROTATION,0f,675f).setDuration(duration).start()
                ObjectAnimator.ofFloat(binding.optionOneContainer,View.TRANSLATION_Y,-170f).setDuration(duration).start()
                ObjectAnimator.ofFloat(binding.optionTwoContainer,View.TRANSLATION_Y,-280f).setDuration(duration).start()
                ObjectAnimator.ofFloat(binding.transparentBackground,View.ALPHA,0.5f).setDuration(duration).start()


                binding.optionOneContainer.animate().alpha(1f).setDuration(duration).setListener(
                    object : AnimatorListenerAdapter() {
                        override fun onAnimationEnd(animation: Animator) {
                            binding.optionOneContainer.isClickable = true
                        }
                    }
                )
                binding.optionTwoContainer.animate().alpha(1f).setDuration(duration).setListener(
                    object : AnimatorListenerAdapter() {
                        override fun onAnimationEnd(animation: Animator) {
                            binding.optionTwoContainer.isClickable = true
                        }
                    }
                )

            }else{
                ObjectAnimator.ofFloat(binding.plusImageView,View.ROTATION,675f,0f).setDuration(duration).start()
                ObjectAnimator.ofFloat(binding.optionOneContainer,View.TRANSLATION_Y,0f).setDuration(duration).start()
                ObjectAnimator.ofFloat(binding.optionTwoContainer,View.TRANSLATION_Y,0f).setDuration(duration).start()
                ObjectAnimator.ofFloat(binding.transparentBackground,View.ALPHA,0f).setDuration(duration).start()

                binding.optionOneContainer.animate().alpha(0f).setDuration(duration).setListener(
                    object : AnimatorListenerAdapter() {
                        override fun onAnimationEnd(animation: Animator) {
                            binding.optionOneContainer.isClickable = false
                        }
                    }
                )

                binding.optionTwoContainer.animate().alpha(0f).setDuration(duration).setListener(
                    object : AnimatorListenerAdapter() {
                        override fun onAnimationEnd(animation: Animator) {
                            binding.optionTwoContainer.isClickable = false
                        }
                    }
                )
            }
        }
    }


}