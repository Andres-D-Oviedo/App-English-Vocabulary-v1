package com.sena.appenglish

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.AppCompatEditText
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import java.text.DecimalFormat

class ActivityLearntAnimals : AppCompatActivity() {

    private var isCatSelected: Boolean = false
    private var isCowSelected: Boolean = false
    private var isPigSelected: Boolean = false
    private var isDogSelected: Boolean = false
    private var isBeeSelected: Boolean = false
    private var isHenSelected: Boolean = false

    private lateinit var viewCatLearnt: CardView
    private lateinit var viewCowLearnt: CardView
    private lateinit var viewPigLearnt: CardView
    private lateinit var viewDogLearnt: CardView
    private lateinit var viewBeeLearnt: CardView
    private lateinit var viewHenLearnt: CardView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_learnt_animals)

        initComponents()
        initListeners()
        initUI()
    }

    private fun initComponents() {
        viewCatLearnt = findViewById(R.id.viewCatLearnt)
        viewCowLearnt = findViewById(R.id.viewCowLearnt)
        viewPigLearnt = findViewById(R.id.viewPigLearnt)
        viewDogLearnt = findViewById(R.id.viewDogLearnt)
        viewBeeLearnt = findViewById(R.id.viewBeeLearnt)
        viewHenLearnt = findViewById(R.id.viewHenLearnt)
    }

    private fun initListeners() {
        viewCatLearnt.setOnClickListener {
            isCatSelected = negateBoolean(isCatSelected)
            setBackgroundColor()
            Sound_Cat()
            isCatSelected = negateBoolean(isCatSelected)
        }

        viewCowLearnt.setOnClickListener {
            isCowSelected  = negateBoolean(isCowSelected )
            setBackgroundColor()
            Sound_Cow()
            isCowSelected  = negateBoolean(isCowSelected )
        }

        viewPigLearnt.setOnClickListener {
            isPigSelected  = negateBoolean(isPigSelected)
            setBackgroundColor()
            Sound_Pig()
            isPigSelected  = negateBoolean(isPigSelected)
        }

        viewDogLearnt.setOnClickListener {
            isDogSelected  = negateBoolean(isDogSelected )
            setBackgroundColor()
            Sound_Dog()
            isDogSelected  = negateBoolean(isDogSelected )
        }

        viewBeeLearnt.setOnClickListener {
            isBeeSelected  = negateBoolean(isBeeSelected )
            setBackgroundColor()
            Sound_Bee()
            isBeeSelected  = negateBoolean(isBeeSelected )
        }

        viewHenLearnt.setOnClickListener {
            isHenSelected  = negateBoolean(isHenSelected )
            setBackgroundColor()
            Sound_Hen()
            isHenSelected  = negateBoolean(isHenSelected )
        }
    }



    fun Sound_Dog() {
        val txtDog = findViewById<TextView>(R.id.txtDog)
        val soundDog = MediaPlayer.create(this,R.raw.dog)
        soundDog.start()
        txtDog.text = getString(R.string.Perro)
    }

    fun Sound_Cow() {
        val txtCow = findViewById<TextView>(R.id.txtCow)
        val soundCow = MediaPlayer.create(this,R.raw.cow)
        soundCow.start()
        txtCow.text = getString(R.string.Vaca)
    }

    fun Sound_Pig() {
        val txtPig = findViewById<TextView>(R.id.txtPig)
        val soundPig = MediaPlayer.create(this,R.raw.pig)
        soundPig.start()
        txtPig.text = getString(R.string.Marrano)
    }

    fun Sound_Cat() {
        val txtCat = findViewById<TextView>(R.id.txtCat)
        val soundCat = MediaPlayer.create(this,R.raw.cat)
        soundCat.start()
        txtCat.text= getString(R.string.Gato)
    }

    fun Sound_Bee() {
        val txtBee = findViewById<TextView>(R.id.txtBee)
        val soundBee = MediaPlayer.create(this,R.raw.bee)
        soundBee.start()
        txtBee.text = getString(R.string.Abeja)
    }

    fun Sound_Hen() {
        val txtHen = findViewById<TextView>(R.id.txtHen)
        val soundHen = MediaPlayer.create(this,R.raw.hen)
        soundHen.start()
        txtHen.text = getString(R.string.Gallina)
    }

    private fun negateBoolean(input: Boolean): Boolean {
        return !input
    }

    private fun setBackgroundColor() {
        viewCatLearnt.setCardBackgroundColor(getBackgroundColor(isCatSelected))
        viewCowLearnt.setCardBackgroundColor(getBackgroundColor(isCowSelected))
        viewPigLearnt.setCardBackgroundColor(getBackgroundColor(isPigSelected))
        viewDogLearnt.setCardBackgroundColor(getBackgroundColor(isDogSelected))
        viewBeeLearnt.setCardBackgroundColor(getBackgroundColor(isBeeSelected))
        viewHenLearnt.setCardBackgroundColor(getBackgroundColor(isHenSelected))
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