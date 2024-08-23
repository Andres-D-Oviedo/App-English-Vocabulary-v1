package com.sena.appenglish

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity

class ActivityWelcome : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val btnNext1 = findViewById<Button>(R.id.btnNext1)
        btnNext1.setOnClickListener { navigateToLogin() }
    }

    private fun navigateToLogin() {
        val intent = Intent(this, ActivityLogin::class.java)
        startActivity(intent)
    }

    private fun navigateToMenu() {
        val intent = Intent(this, ActivityMenu::class.java)
        startActivity(intent)
    }

}


