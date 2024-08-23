package com.sena.appenglish

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.sena.appenglish.databinding.ActivityPlayAnimalPigBinding

class ActivityPlayAnimalPig : AppCompatActivity() {

    private lateinit var binding: ActivityPlayAnimalPigBinding

    private var score = ActivityPlayAnimalDog.scoreGlobal

    private var isOptDogSelected: Boolean = false
    private var isOptPigSelected: Boolean = false
    private var isOptCatSelected: Boolean = false
    private var isOptCowSelected: Boolean = false
    private var isOptHenSelected: Boolean = false
    private var isOptBeeSelected: Boolean = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlayAnimalPigBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initListeners()
        initUI()
    }

    private fun initListeners() {
        binding.btnPlayOptDog.setOnClickListener {
            isOptDogSelected = negateBoolean(isOptDogSelected)
            setIncorrectColor()
            sound_Dog()
            delay(2000)
            Sound_Wrong()
        }

        binding.btnPlayOptCat.setOnClickListener {
            isOptCatSelected = negateBoolean(isOptCatSelected)
            setIncorrectColor()
            sound_Cat()
            delay(2000)
            Sound_Wrong()
        }

        binding.btnPlayOptCow.setOnClickListener {
            isOptCowSelected = negateBoolean(isOptCowSelected)
            setIncorrectColor()
            sound_Cow()
            delay(2000)
            Sound_Wrong()
        }

        binding.btnPlayOptBee.setOnClickListener {
            isOptBeeSelected = negateBoolean(isOptBeeSelected)
            setIncorrectColor()
            sound_Bee()
            delay(2000)
            Sound_Wrong()
        }

        binding.btnPlayOptHen.setOnClickListener {
            isOptHenSelected = negateBoolean(isOptHenSelected)
            setIncorrectColor()
            sound_Hen()
            delay(2000)
            Sound_Wrong()
        }

        binding.btnPlayOptPig.setOnClickListener {
            isOptPigSelected = negateBoolean(isOptPigSelected)
            setCorrectColor()
            sound_Pig()
            delay(2000)
            Sound_Correct()
            score += 1
            binding.tvScoreGood.text = "$score"
            setScore()
        }

        binding.btnPlayNext.setOnClickListener{
            navigateToActivityPlay()
        }

    }

    private fun navigateToActivityPlay(){
        val intent = Intent(this, ActivityPlay::class.java)
        ActivityPlayAnimalDog.scoreGlobal = score
        startActivity(intent)
    }

    private fun setScore() {
        binding.tvScoreGood.text = score.toString()
        Toast.makeText(this, "puntaje"+score, Toast.LENGTH_SHORT).show()
    }

    private fun negateBoolean(input: Boolean): Boolean {
        return !input
    }

    private fun setIncorrectColor() {

        binding.viewCard.setCardBackgroundColor(getIncorrectColor(isOptCatSelected))
        binding.viewCard.setCardBackgroundColor(getIncorrectColor(isOptDogSelected))
        binding.viewCard.setCardBackgroundColor(getIncorrectColor(isOptCowSelected))
        binding.viewCard.setCardBackgroundColor(getIncorrectColor(isOptBeeSelected))
        binding.viewCard.setCardBackgroundColor(getIncorrectColor(isOptHenSelected))

    }

    private fun setCorrectColor() {

        binding.viewCard.setCardBackgroundColor(getCorrectColor(isOptPigSelected))
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

    fun sound_Dog() {
        val soundDog = MediaPlayer.create(this, R.raw.dog)
        soundDog.start()
    }

    fun sound_Cat() {
        val soundCat = MediaPlayer.create(this, R.raw.cat)
        soundCat.start()
    }

    fun sound_Bee() {
        val soundBee = MediaPlayer.create(this, R.raw.bee)
        soundBee.start()
    }

    fun sound_Cow() {
        val soundCow = MediaPlayer.create(this, R.raw.cow)
        soundCow.start()
    }

    fun sound_Pig() {
        val soundPig = MediaPlayer.create(this, R.raw.pig)
        soundPig.start()
    }

    fun sound_Hen() {
        val soundHen = MediaPlayer.create(this, R.raw.hen)
        soundHen.start()
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