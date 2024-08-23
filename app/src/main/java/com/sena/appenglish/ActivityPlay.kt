package com.sena.appenglish

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.media.MediaPlayer
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.sena.appenglish.databinding.ActivityPlayBinding
import com.sena.appenglish.databinding.ActivityPlayColorWhiteBinding


class ActivityPlay : AppCompatActivity() {

    private var puntaje:Double = 1.0

    private lateinit var binding: ActivityPlayBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlayBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //val btnAlphabetPlay = findViewById<Button>(R.id.btnAlphabetPlay)
        binding.btnAlphabetPlay.setOnClickListener { navigateToActivityPlayColorPink(puntaje) }

        //val btnColorsPlay = findViewById<Button>(R.id.btnColorsPlay)
        binding.btnColorsPlay.setOnClickListener { navigateToPlayColorWhite() }

        //val btnFruitsPlay = findViewById<Button>(R.id.btnFruitsPlay)
        binding.btnFruitsPlay.setOnClickListener { navigateToPlayFruitBanana() }

        //val btnAnimalsPlay = findViewById<Button>(R.id.btnAnimalsPlay)
        binding.btnAnimalsPlay.setOnClickListener { navigateToPlayAnimalDog() }
    }


    private fun navigateToPlayAlphabet() {
        val intent = Intent(this, ActivityLearntAlphabet::class.java)
        startActivity(intent)
    }

    private fun navigateToPlayColorWhite() {
        val intent = Intent(this, ActivityPlayColorWhite::class.java)
        startActivity(intent)
    }

    private fun navigateToActivityPlayColorPink(scoreGlobal: Double){
        val intent = Intent(this, ActivityPlayColorPink::class.java)
        //intent.putExtra(ActivityPlayColorWhite.SCORE_KEY, scoreGlobal)
        startActivity(intent)
    }

    private fun navigateToPlayFruitBanana() {
        val intent = Intent(this, ActivityPlayFruitBanana::class.java)
        startActivity(intent)
    }

    private fun navigateToPlayAnimalDog() {
        val intent = Intent(this, ActivityPlayAnimalDog::class.java)
        startActivity(intent)
    }

}