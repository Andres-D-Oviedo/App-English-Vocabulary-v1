package com.sena.appenglish

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat

class ActivityLearntFruits : AppCompatActivity() {

    private var isAppleSelected: Boolean = false
    private var isBananaSelected: Boolean = false
    private var isOrangeSelected: Boolean = false
    private var isLemonSelected: Boolean = false
    private var isPineappleSelected: Boolean = false
    private var isStrawberrySelected: Boolean = false

    private lateinit var viewAppleLearnt: CardView
    private lateinit var viewBananaLearnt: CardView
    private lateinit var viewOrangeLearnt: CardView
    private lateinit var viewLemonLearnt: CardView
    private lateinit var viewPineappleLearnt: CardView
    private lateinit var viewStrawberryLearnt: CardView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_learnt_fruits)

        initComponents()
        initListeners()
        initUI()

    }

    private fun initComponents() {
        viewAppleLearnt = findViewById(R.id.viewAppleLearnt)
        viewBananaLearnt = findViewById(R.id.viewBananaLearnt)
        viewOrangeLearnt = findViewById(R.id.viewOrangeLearnt)
        viewLemonLearnt = findViewById(R.id.viewLemonLearnt)
        viewPineappleLearnt = findViewById(R.id.viewPineappleLearnt)
        viewStrawberryLearnt = findViewById(R.id.viewStrawberryLearnt)
    }

    private fun initListeners() {
        viewAppleLearnt.setOnClickListener {
            isAppleSelected = negateBoolean(isAppleSelected)
            setBackgroundColor()
            Sound_Apple()
            isAppleSelected = negateBoolean(isAppleSelected)
        }

        viewBananaLearnt.setOnClickListener {
            isBananaSelected  = negateBoolean(isBananaSelected )
            setBackgroundColor()
            Sound_Banana()
            isBananaSelected  = negateBoolean(isBananaSelected )
        }

        viewOrangeLearnt.setOnClickListener {
            isOrangeSelected  = negateBoolean(isOrangeSelected)
            setBackgroundColor()
            Sound_Orange()
            isOrangeSelected  = negateBoolean(isOrangeSelected)
        }

        viewLemonLearnt.setOnClickListener {
            isLemonSelected  = negateBoolean(isLemonSelected )
            setBackgroundColor()
            Sound_Lemon()
            isLemonSelected  = negateBoolean(isLemonSelected )
        }

        viewPineappleLearnt.setOnClickListener {
            isPineappleSelected  = negateBoolean(isPineappleSelected )
            setBackgroundColor()
            Sound_Pineapple()
            isPineappleSelected  = negateBoolean(isPineappleSelected )
        }

        viewStrawberryLearnt.setOnClickListener {
            isStrawberrySelected  = negateBoolean(isStrawberrySelected )
            setBackgroundColor()
            Sound_Strawberry()
            isStrawberrySelected  = negateBoolean(isStrawberrySelected )
        }
    }

    fun Sound_Apple() {
        val txtApple = findViewById<TextView>(R.id.txtApple)
        val soundApple = MediaPlayer.create(this, R.raw.apple)
        soundApple.start()
        txtApple.text = getString(R.string.Manzana)
    }

    fun Sound_Banana() {
        val txtBanana = findViewById<TextView>(R.id.txtBanana)
        val soundBanana = MediaPlayer.create(this, R.raw.banana)
        soundBanana.start()
        txtBanana.text = getString(R.string.Banano)
    }

    fun Sound_Orange() {
        val txtOrange = findViewById<TextView>(R.id.txtOrange)
        val soundOrange = MediaPlayer.create(this, R.raw.orange)
        soundOrange.start()
        txtOrange.text = getString(R.string.Naranja)
    }

    fun Sound_Lemon() {
        val txtLemon = findViewById<TextView>(R.id.txtLemon)
        val soundLemon = MediaPlayer.create(this, R.raw.lemon)
        soundLemon.start()
        txtLemon.text = getString(R.string.Limón)
    }

    fun Sound_Pineapple() {
        val txtPineapple = findViewById<TextView>(R.id.txtPineapple)
        val soundPineapple = MediaPlayer.create(this, R.raw.pineapple)
        soundPineapple.start()
        txtPineapple.text = getString(R.string.Piña)
    }

    fun Sound_Strawberry() {
        val txtStrawberry = findViewById<TextView>(R.id.txtStrawberry)
        val soundStrawberry = MediaPlayer.create(this, R.raw.strawberry)
        soundStrawberry.start()
        txtStrawberry.text = getString(R.string.Fresa)
    }

    private fun negateBoolean(input: Boolean): Boolean {
        return !input
    }


    private fun setBackgroundColor() {
        viewAppleLearnt.setCardBackgroundColor(getBackgroundColor(isAppleSelected))
        viewBananaLearnt.setCardBackgroundColor(getBackgroundColor(isBananaSelected))
        viewOrangeLearnt.setCardBackgroundColor(getBackgroundColor(isOrangeSelected))
        viewLemonLearnt.setCardBackgroundColor(getBackgroundColor(isLemonSelected))
        viewPineappleLearnt.setCardBackgroundColor(getBackgroundColor(isPineappleSelected))
        viewStrawberryLearnt.setCardBackgroundColor(getBackgroundColor(isStrawberrySelected))
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

