package com.example.islamii

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.islamii.main_activity.main_frament.MainActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler(Looper.getMainLooper()).postDelayed({

        val intent = Intent(this@SplashActivity, MainActivity::class.java)
            startActivity(intent)
            finish()

        }, 2000)
    }
}