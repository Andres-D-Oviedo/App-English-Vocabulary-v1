package com.sena.appenglish

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat

class ActivityLearntColors : AppCompatActivity() {

    private var isWhiteSelected: Boolean = false
    private var isYellowSelected: Boolean = false
    private var isGreenSelected: Boolean = false
    private var isPinkSelected: Boolean = false
    private var isRedSelected: Boolean = false
    private var isBrownSelected: Boolean = false

    private lateinit var viewWhiteLearnt: CardView
    private lateinit var viewYellowLearnt: CardView
    private lateinit var viewGreenLearnt: CardView
    private lateinit var viewPinkLearnt: CardView
    private lateinit var viewRedLearnt: CardView
    private lateinit var viewBrownLearnt: CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_learnt_colors)

        initComponents()
        initListeners()
        initUI()

    }

    private fun initComponents() {
        viewWhiteLearnt = findViewById(R.id.viewWhiteLearnt)
        viewYellowLearnt = findViewById(R.id.viewYellowLearnt)
        viewGreenLearnt = findViewById(R.id.viewGreenLearnt)
        viewPinkLearnt = findViewById(R.id.viewPinkLearnt)
        viewRedLearnt = findViewById(R.id.viewRedLearnt)
        viewBrownLearnt = findViewById(R.id.viewBrownLearnt)
    }

    private fun initListeners() {
        viewWhiteLearnt.setOnClickListener {
            isWhiteSelected = negateBoolean(isWhiteSelected)
            setBackgroundColor()
            Sound_White()
            isWhiteSelected = negateBoolean(isWhiteSelected)
        }

        viewYellowLearnt.setOnClickListener {
            isYellowSelected  = negateBoolean(isYellowSelected )
            setBackgroundColor()
            Sound_Yellow()
            isYellowSelected  = negateBoolean(isYellowSelected )
        }

        viewGreenLearnt.setOnClickListener {
            isGreenSelected  = negateBoolean(isGreenSelected)
            setBackgroundColor()
            Sound_Green()
            isGreenSelected  = negateBoolean(isGreenSelected)
        }

        viewPinkLearnt.setOnClickListener {
            isPinkSelected  = negateBoolean(isPinkSelected )
            setBackgroundColor()
            Sound_Pink()
            isPinkSelected  = negateBoolean(isPinkSelected )
        }

        viewRedLearnt.setOnClickListener {
            isRedSelected  = negateBoolean(isRedSelected )
            setBackgroundColor()
            Sound_Red()
            isRedSelected  = negateBoolean(isRedSelected )
        }

        viewBrownLearnt.setOnClickListener {
            isBrownSelected  = negateBoolean(isBrownSelected )
            setBackgroundColor()
            Sound_Brown()
            isBrownSelected  = negateBoolean(isBrownSelected )
        }
    }

    fun Sound_Pink() {
        val txtPink = findViewById<TextView>(R.id.txtPink)
        val soundPink = MediaPlayer.create(this, R.raw.pink)
        soundPink.start()
        txtPink.text = getString(R.string.Rosado)
    }

    fun Sound_White() {
        val txtWhite = findViewById<TextView>(R.id.txtWhite)
        val soundWhite = MediaPlayer.create(this, R.raw.white)
        soundWhite.start()
        txtWhite.text = getString(R.string.Blanco)
    }

    fun Sound_Green() {
        val txtGreen = findViewById<TextView>(R.id.txtGreen)
        val soundGreen = MediaPlayer.create(this, R.raw.green)
        soundGreen.start()
        txtGreen.text = getString(R.string.Verde)
    }

    fun Sound_Yellow() {
        val txtYellow = findViewById<TextView>(R.id.txtYellow)
        val soundYellow = MediaPlayer.create(this, R.raw.yellow)
        soundYellow.start()
        txtYellow.text = getString(R.string.Amarillo)
    }

    fun Sound_Red() {
        val txtRed = findViewById<TextView>(R.id.txtRed)
        val soundRed = MediaPlayer.create(this, R.raw.red)
        soundRed.start()
        txtRed.text = getString(R.string.Rojo)
    }

    fun Sound_Brown() {
        val txtBrown = findViewById<TextView>(R.id.txtBrown)
        val soundBrown = MediaPlayer.create(this, R.raw.brown)
        soundBrown.start()
        txtBrown.text = getString(R.string.Cafe)
    }

    private fun negateBoolean(input: Boolean): Boolean {
        return !input
    }


    private fun setBackgroundColor() {
        viewYellowLearnt.setCardBackgroundColor(getBackgroundColor(isYellowSelected))
        viewGreenLearnt.setCardBackgroundColor(getBackgroundColor(isGreenSelected))
        viewPinkLearnt.setCardBackgroundColor(getBackgroundColor(isPinkSelected))
        viewRedLearnt.setCardBackgroundColor(getBackgroundColor(isRedSelected))
        viewBrownLearnt.setCardBackgroundColor(getBackgroundColor(isBrownSelected))
        viewWhiteLearnt.setCardBackgroundColor(getBackgroundColor(isWhiteSelected))
    }

    private fun getBackgroundColor(isSelectedComponent: Boolean): Int {

        val colorReference = if (isSelectedComponent) {
            R.color.background_component_selected
        } else {
            R.color.background_component
        }
        return ContextCompat.getColor(this, colorReference)
    }

    private fun initUI() {
        setBackgroundColor()
    }

}