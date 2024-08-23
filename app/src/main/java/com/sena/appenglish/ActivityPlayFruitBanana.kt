package com.sena.appenglish

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.sena.appenglish.databinding.ActivityPlayFruitBananaBinding


class ActivityPlayFruitBanana : AppCompatActivity() {

    private lateinit var binding: ActivityPlayFruitBananaBinding

    private var currentScore: Int = 0

    private var isOptBananaSelected: Boolean = false
    private var isOptLemonSelected: Boolean = false
    private var isOptAppleSelected: Boolean = false
    private var isOptOrangeSelected: Boolean = false
    private var isOptPineappleSelected: Boolean = false
    private var isOptStrawberrySelected: Boolean = false

    companion object {
        var scoreGlobal: Int = 0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlayFruitBananaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initListeners()
        initUI()
    }

    private fun initListeners() {
        binding.btnPlayOptBanana.setOnClickListener {
            isOptBananaSelected = negateBoolean(isOptBananaSelected)
            setCorrectColor()
            sound_Banana()
            delay(2000)
            Sound_Correct()
            currentScore += 1
            binding.tvScoreGood.text = "$currentScore"
            setScore()
        }

        binding.btnPlayOptLemon.setOnClickListener {
            isOptLemonSelected = negateBoolean(isOptLemonSelected)
            setIncorrectColor()
            sound_Lemon()
            delay(2000)
            Sound_Wrong()
        }

        binding.btnPlayOptApple.setOnClickListener {
            isOptAppleSelected = negateBoolean(isOptAppleSelected)
            setIncorrectColor()
            sound_Apple()
            delay(2000)
            Sound_Wrong()
        }

        binding.btnPlayOptOrange.setOnClickListener {
            isOptOrangeSelected = negateBoolean(isOptOrangeSelected)
            setIncorrectColor()
            sound_Orange()
            delay(2000)
            Sound_Wrong()
        }

        binding.btnPlayOptPineapple.setOnClickListener {
            isOptPineappleSelected = negateBoolean(isOptPineappleSelected)
            setIncorrectColor()
            sound_Pineapple()
            delay(2000)
            Sound_Wrong()
        }

        binding.btnPlayOptStrawberry.setOnClickListener {
            isOptStrawberrySelected = negateBoolean(isOptStrawberrySelected)
            setIncorrectColor()
            sound_Strawberry()
            delay(2000)
            Sound_Wrong()
        }

        binding.btnPlayNext.setOnClickListener{

        }
    }

        private fun navigateToActivityPlayFruitLemon(){
            val intent = Intent(this, ActivityPlayFruitLemon::class.java)
            ActivityPlayFruitBanana.scoreGlobal = currentScore
            startActivity(intent)
        }

        private fun setScore() {
            binding.tvScoreGood.text = currentScore.toString()
            Toast.makeText(this, "puntaje"+currentScore, Toast.LENGTH_SHORT).show()
        }

        private fun negateBoolean(input: Boolean): Boolean {
            return !input
        }

        private fun setIncorrectColor() {

            binding.viewCard.setCardBackgroundColor(getIncorrectColor(isOptPineappleSelected))
            binding.viewCard.setCardBackgroundColor(getIncorrectColor(isOptLemonSelected))
            binding.viewCard.setCardBackgroundColor(getIncorrectColor(isOptAppleSelected))
            binding.viewCard.setCardBackgroundColor(getIncorrectColor(isOptOrangeSelected))
            binding.viewCard.setCardBackgroundColor(getIncorrectColor(isOptStrawberrySelected))
        }

        private fun setCorrectColor() {
            binding.viewCard.setCardBackgroundColor(getCorrectColor(isOptBananaSelected))
        }

        private fun getIncorrectColor(isSelectedComponent: Boolean): Int {

            val colorReference = if (isSelectedComponent) {
                R.color.incorrecto
            } else {
                R.color.incorrecto
            }
            return ContextCompat.getColor(this, colorReference)
        }

        private fun getCorrectColor(isSelectedComponent: Boolean): Int {

            val colorReference = if (isSelectedComponent) {
                R.color.correcto
            } else {
                R.color.todo_background_card
            }
            return ContextCompat.getColor(this, colorReference)
        }

        fun sound_Banana() {
            val soundBanana = MediaPlayer.create(this, R.raw.banana)
            soundBanana.start()
        }

        fun sound_Apple() {
            val soundApple = MediaPlayer.create(this, R.raw.apple)
            soundApple.start()
        }

        fun sound_Orange() {
            val soundOrange = MediaPlayer.create(this, R.raw.orange)
            soundOrange.start()
        }

        fun sound_Pineapple() {
            val soundPineapple = MediaPlayer.create(this, R.raw.pineapple)
            soundPineapple.start()
        }

        fun sound_Lemon() {
            val soundLemon = MediaPlayer.create(this, R.raw.lemon)
            soundLemon.start()
        }

        fun sound_Strawberry() {
            val soundStrawberry = MediaPlayer.create(this, R.raw.strawberry)
            soundStrawberry.start()
        }

        fun Sound_Wrong() {
            val soundBad = MediaPlayer.create(this, R.raw.wrong)
            soundBad.start()
        }

        fun Sound_Correct() {
            val soundGood = MediaPlayer.create(this, R.raw.correct)
            soundGood.start()
        }

        fun delay(milliseconds: Long) {
            Thread.sleep(milliseconds)
        }

        private fun initUI() {
            setIncorrectColor()
            setCorrectColor()
            setScore()
        }
}