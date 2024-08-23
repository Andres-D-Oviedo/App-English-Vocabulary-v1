package com.sena.appenglish

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.sena.appenglish.databinding.ActivityPlayColorWhiteBinding

class ActivityPlayColorWhite : AppCompatActivity() {



    private lateinit var binding: ActivityPlayColorWhiteBinding

    private var currentScore: Int = 0
    private lateinit var tvScoreGood: TextView

    private var isOptGreenSelected: Boolean = false
    private var isOptYellowSelected: Boolean = false
    private var isOptWhiteSelected: Boolean = false
    private var isOptPinkSelected: Boolean = false


    /*companion object{
        const val SCORE_KEY = "SCORE_RESULT"
    }*/

    companion object {
        var scoreGlobal: Int = 0
    }

    /*private lateinit var btnPlayOptGreen: Button
    private lateinit var btnPlayOptYellow: Button
    private lateinit var btnPlayOptWhite: Button
    private lateinit var btnPlayOptPink: Button
    private lateinit var viewColorCard: CardView*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPlayColorWhiteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //initComponents()
        initListeners()
        initUI()
    }

    private fun initComponents() {
        /*btnPlayOptGreen = findViewById(R.id.btnPlayOptGreen)
        btnPlayOptYellow = findViewById(R.id.btnPlayOptYellow)
        btnPlayOptWhite = findViewById(R.id.btnPlayOptWhite)
        btnPlayOptPink = findViewById(R.id.btnPlayOptPink)
        viewColorCard = findViewById(R.id.viewColorCard)

        tvScoreGood = findViewById(R.id.tvScoreGood)*/
    }


    private fun initListeners() {
        binding.btnPlayOptGreen.setOnClickListener {
            isOptGreenSelected = negateBoolean(isOptGreenSelected)
            setIncorrectColor()
            Sound_Green()
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

        binding.btnPlayOptPink.setOnClickListener {
            isOptPinkSelected = negateBoolean(isOptPinkSelected)
            setIncorrectColor()
            Sound_Pink()
            delay(2000)
            Sound_Wrong()
        }

        binding.btnPlayOptWhite.setOnClickListener {
            isOptWhiteSelected = negateBoolean(isOptWhiteSelected)
            setCorrectColor()
            Sound_White()
            delay(2000)
            Sound_Correct()
            currentScore = currentScore + 1
            binding.tvScoreGood.text = "$currentScore"
            setScore()
        }

        binding.btnPlayNext.setOnClickListener{
            navigateToActivityPlayColorPink()
        }

    }

    private fun navigateToActivityPlayColorPink(){
        val intent = Intent(this, ActivityPlayColorPink::class.java)
        //intent.putExtra(SCORE_KEY, currentScore)
        scoreGlobal = currentScore
        startActivity(intent)
    }

    private fun setScore() {
        binding.tvScoreGood.text = currentScore.toString()
        Toast.makeText(this, "puntajeeeee"+currentScore, Toast.LENGTH_SHORT).show()
    }

    private fun negateBoolean(input: Boolean): Boolean {
        return !input
    }

    private fun setIncorrectColor() {

        binding.viewColorCard.setCardBackgroundColor(getIncorrectColor(isOptGreenSelected))
        binding.viewColorCard.setCardBackgroundColor(getIncorrectColor(isOptYellowSelected))
        binding.viewColorCard.setCardBackgroundColor(getIncorrectColor(isOptPinkSelected))
    }

    private fun setCorrectColor() {
        binding.viewColorCard.setCardBackgroundColor(getCorrectColor(isOptWhiteSelected))
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

