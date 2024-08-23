package com.sena.appenglish

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ActivityMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val btnLearnt = findViewById<Button>(R.id.btnLearnt)
        btnLearnt.setOnClickListener { navigateToLearnt() }

        val btnPlay = findViewById<Button>(R.id.btnPlay)
        btnPlay.setOnClickListener { navigateToPlay() }

    }


    private fun navigateToLearnt() {
        val intent = Intent(this, ActivityLearnt::class.java)
        startActivity(intent)
    }

    private fun navigateToPlay() {
        val intent = Intent(this, ActivityPlay::class.java)
        startActivity(intent)
    }
}