package com.gb.m_2090_3.view.animation

import android.os.Bundle
import android.view.animation.AnticipateOvershootInterpolator
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintSet
import androidx.transition.ChangeBounds
import androidx.transition.TransitionManager
import com.gb.m_2090_3.R
import com.gb.m_2090_3.databinding.ActivityAnimationStartBinding


class AnimationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAnimationStartBinding

    var isFlag = false
    var duration = 1000L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnimationStartBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val constraintSet = ConstraintSet()
        //constraintSetStart.clone(binding.constraintContainer)
        constraintSet.clone(this,R.layout.activity_animation_start)

        binding.tap.setOnClickListener {
            isFlag = !isFlag

            val changeBounds = ChangeBounds()
            changeBounds.duration = 1000L
            changeBounds.interpolator = AnticipateOvershootInterpolator(5.0f)
            TransitionManager.beginDelayedTransition(binding.constraintContainer,changeBounds)
            if(isFlag){
                constraintSet.connect(R.id.title,ConstraintSet.RIGHT,R.id.backgroundImage,ConstraintSet.RIGHT)
                //constraintSet.clear(R.id.title,ConstraintSet.RIGHT)
            }else{
                constraintSet.connect(R.id.title,ConstraintSet.RIGHT,R.id.backgroundImage,ConstraintSet.LEFT)
            }
            constraintSet.applyTo(binding.constraintContainer)
        }
    }


}