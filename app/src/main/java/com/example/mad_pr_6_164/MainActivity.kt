package com.example.mad_pr_6_164


import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val heartImage = findViewById<ImageView>(R.id.heart)
        val heartAnimation=heartImage.background as AnimationDrawable
        heartAnimation.start()

        val alarmImage = findViewById<ImageView>(R.id.alarm_imageview)
        val alarmAnimation=alarmImage.background as AnimationDrawable
        alarmAnimation.start()

    }
}