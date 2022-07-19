package com.gb.m_2090_3.view.ux

import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.gb.m_2090_3.MainActivity
import com.gb.m_2090_3.R


class SplashActivity : AppCompatActivity() { //TODO HW single-activity пытаемся сохранить
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        findViewById<ImageView>(R.id.icon).animate().rotation(7200f).setDuration(20000L).start()

        //ObjectAnimator.ofFloat(findViewById<ImageView>(R.id.icon),View.ROTATION,720f).setDuration(2000L).start()

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this,UXActivity::class.java))
            finish()
        },2000L)
    }
}