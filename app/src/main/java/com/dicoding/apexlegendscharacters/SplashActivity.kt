package com.dicoding.apexlegendscharacters

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({
            // Intent untuk pindah ke activity utama
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // Tutup activity SplashScreen
        }, 2000L)

    }
}