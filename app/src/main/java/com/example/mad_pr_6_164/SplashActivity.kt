package com.example.mad_pr_6_164

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SplashActivity : AppCompatActivity(), Animation.AnimationListener {
    lateinit var gunianimation: AnimationDrawable
    lateinit var tweenanimation: Animation
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }
        val uvpce_imageview = findViewById<ImageView>(R.id.uvpce_imageview)
        uvpce_imageview.setBackgroundResource(R.drawable.uvpce_animation_list)
        gunianimation = uvpce_imageview.background as AnimationDrawable
        tweenanimation = AnimationUtils.loadAnimation(this, R.anim.grow)
        tweenanimation.setAnimationListener(this)

    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) {
            gunianimation.start()
            findViewById<ImageView>(R.id.uvpce_imageview).startAnimation(tweenanimation)
        } else {
            gunianimation.stop()
        }
    }

    override fun onAnimationStart(p0: Animation?) {

    }

    override fun onAnimationEnd(p0: Animation?) {
        Intent(this, MainActivity::class.java).also {
            startActivity(it)
        }
    }
    override fun onAnimationRepeat(p0: Animation?) {

    }
}