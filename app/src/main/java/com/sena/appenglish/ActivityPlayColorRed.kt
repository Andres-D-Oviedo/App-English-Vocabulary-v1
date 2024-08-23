package com.sena.appenglish

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.sena.appenglish.databinding.ActivityPlayColorRedBinding

class ActivityPlayColorRed : AppCompatActivity() {

    private lateinit var binding: ActivityPlayColorRedBinding

    private var score = ActivityPlayColorWhite.scoreGlobal

    private var isOptGreenSelected: Boolean = false
    private var isOptYellowSelected: Boolean = false
    private var isOptWhiteSelected: Boolean = false
    private var isOptPinkSelected: Boolean = false
    private var isOptBrownSelected: Boolean = false
    private var isOptRedSelected: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlayColorRedBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initListeners()
        initUI()

    }

    private fun initListeners() {
        binding.btnPlayOptBrown.setOnClickListener {
            isOptBrownSelected = negateBoolean(isOptBrownSelected)
            setIncorrectColor()
            Sound_Brown()
            delay(2000)
            Sound_Wrong()


        }

        binding.btnPlayOptYellow.setOnClickListener {
            isOptYellowSelected = negateBoolean(isOptYellowSelected)
            setIncorrectColor()
            Sound_Yellow()
            delay(2000)
            Sound_Wrong()
        }

        binding.btnPlayOptRed.setOnClickListener {
            isOptRedSelected = negateBoolean(isOptRedSelected)
            setCorrectColor()
            Sound_Red()
            delay(2000)
            Sound_Correct()
            score += 1
            binding.tvScoreGood.text = "$score"
            setScore()
        }

        binding.btnPlayOptWhite.setOnClickListener {
            isOptWhiteSelected = negateBoolean(isOptWhiteSelected)
            Sound_White()
            delay(2000)
            setIncorrectColor()
            Sound_Wrong()
        }

        binding.btnPlayNext.setOnClickListener{
            navigateToActivityPlay()
            ActivityPlayColorWhite.scoreGlobal =  0
        }

    }

    private fun navigateToActivityPlay(){
        val intent = Intent(this, ActivityPlay::class.java)
        startActivity(intent)
    }


    private fun setScore() {
        binding.tvScoreGood.text =  score.toString()
        Toast.makeText(this, "puntajeeeee"+ score, Toast.LENGTH_SHORT).show()
    }

    private fun negateBoolean(input: Boolean): Boolean {
        return !input
    }

    private fun setIncorrectColor() {

        binding.viewColorCard.setCardBackgroundColor(getIncorrectColor(isOptBrownSelected))
        binding.viewColorCard.setCardBackgroundColor(getIncorrectColor(isOptYellowSelected))
        binding.viewColorCard.setCardBackgroundColor(getIncorrectColor(isOptWhiteSelected))
    }

    private fun setCorrectColor() {
        binding.viewColorCard.setCardBackgroundColor(getCorrectColor(isOptRedSelected))
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

    fun Sound_Pink() {
        val soundPink = MediaPlayer.create(this, R.raw.pink)
        soundPink.start()
    }

    fun Sound_White() {
        val soundWhite = MediaPlayer.create(this, R.raw.white)
        soundWhite.start()
    }

    fun Sound_Green() {
        val soundGreen = MediaPlayer.create(this, R.raw.green)
        soundGreen.start()
    }

    fun Sound_Yellow() {
        val soundYellow = MediaPlayer.create(this, R.raw.yellow)
        soundYellow.start()
    }

    fun Sound_Red() {
        val soundRed = MediaPlayer.create(this, R.raw.red)
        soundRed.start()
    }

    fun Sound_Brown() {
        val soundBrown = MediaPlayer.create(this, R.raw.brown)
        soundBrown.start()
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