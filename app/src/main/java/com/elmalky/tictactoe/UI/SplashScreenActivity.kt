package com.elmalky.tictactoe.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.databinding.DataBindingUtil
import com.elmalky.tictactoe.R
import com.elmalky.tictactoe.databinding.ActivitySplashScreenBinding

class SplashScreenActivity : AppCompatActivity() {
    lateinit var binder: ActivitySplashScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binder = DataBindingUtil.setContentView(this, R.layout.activity_splash_screen)
        Handler().postDelayed({
            startActivity(Intent(this, GamePlayersActivity::class.java))
            finish()
        }, 1500)
    }
}