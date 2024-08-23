package com.sena.appenglish

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.sena.appenglish.databinding.ActivityLearntBinding
import com.sena.appenglish.databinding.ActivityPlayBinding

class ActivityLearnt : AppCompatActivity() {

    private lateinit var binding: ActivityLearntBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityLearntBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //val btnAlphabetLearnt = findViewById<Button>(R.id.btnAlphabetLearnt)
        binding.btnAlphabetLearnt.setOnClickListener { navigateToLearntAlphabet() }

        //val btnColorsLearnt = findViewById<Button>(R.id.btnColorsLearnt)
        binding.btnColorsLearnt.setOnClickListener { navigateToLearntColors() }

        //val btnFruitsLearnt = findViewById<Button>(R.id.btnFruitsLearnt)
        binding.btnFruitsLearnt.setOnClickListener { navigateToLearntFruits() }

        //val btnAnimalsLearnt = findViewById<Button>(R.id.btnAnimalsLearnt)
        binding.btnAnimalsLearnt.setOnClickListener { navigateToLearntAnimals() }
    }


    private fun navigateToLearntAlphabet() {
        val intent = Intent(this, ActivityLearntAlphabet::class.java)
        startActivity(intent)
    }

    private fun navigateToLearntColors() {
        val intent = Intent(this, ActivityLearntColors::class.java)
        startActivity(intent)
    }

    private fun navigateToLearntFruits() {
        val intent = Intent(this, ActivityLearntFruits::class.java)
        startActivity(intent)
    }

    private fun navigateToLearntAnimals() {
        val intent = Intent(this, ActivityLearntAnimals::class.java)
        startActivity(intent)
    }

}