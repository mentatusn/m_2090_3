package com.gb.m_2090_3.view.ux

import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.ContentLoadingProgressBar
import com.gb.m_2090_3.MainActivity
import com.gb.m_2090_3.R
import com.google.android.material.progressindicator.LinearProgressIndicator


class SplashActivity : AppCompatActivity() { //TODO HW single-activity пытаемся сохранить
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val progress = findViewById<LinearProgressIndicator>(R.id.progress)

        //findViewById<ImageView>(R.id.progress).animate().rotation(7200f).setDuration(20000L).start()

        //ObjectAnimator.ofFloat(findViewById<ImageView>(R.id.icon),View.ROTATION,720f).setDuration(2000L).start()
       // progress.progress = 50
        val fullTime = 5000f
        object:CountDownTimer(fullTime.toLong(),1L){
            override fun onTick(millisUntilFinished: Long) {
                val process = ((1- millisUntilFinished/fullTime)*100).toInt()
                if(progress.progress!=process)
                progress.progress =process
            }

            override fun onFinish() {
                startActivity(Intent(this@SplashActivity,UXActivity::class.java))
                finish()
            }

        }.start()

        /*Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this,UXActivity::class.java))
            finish()
        },)*/
    }
}