package com.sena.appenglish

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sena.appenglish.databinding.ActivityLoginBinding

class ActivityLogin : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initListeners()
        initUI()
    }

    private fun initUI() {
        binding.btnLogin.setOnClickListener { checkCredentials() }
    }

    private fun initListeners() {
        binding.btnRegisterUsuario.setOnClickListener {
            navigateToRegister()
        }
    }

    private fun navigateToRegister() {
        val intent = Intent(this, ActivityRegister::class.java)
        startActivity(intent)
    }

    private fun navigateToMenu() {
        val intent = Intent(this, ActivityMenu::class.java)
        startActivity(intent)
    }

    private fun checkCredentials() {
        val storedUser = AppEnglishApplication.prefs.getUser()
        val storedPassword = AppEnglishApplication.prefs.getPassword()
        val enteredUser = binding.etUser.text.toString()
        val enteredPassword = binding.etPassword.text.toString()

        if (enteredUser == storedUser && enteredPassword == storedPassword) {
            // Credenciales válidas, redirigir a la próxima actividad
            startActivity(Intent(this, ActivityMenu::class.java))
            finish() // Terminar esta actividad para evitar que el usuario regrese a ella
        } else {
            println("Credenciales incorrectas")
        }
    }
}

