package com.sena.appenglish

import android.content.Intent
import android.icu.lang.UCharacter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sena.appenglish.databinding.ActivityRegisterBinding

class ActivityRegister : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initUI()
    }

    fun initUI(){
        binding.btnSaveUser.setOnClickListener {
            accesToDetail()
        }
    }

    private fun accesToDetail(){
        var i: Int = 0
        if(binding.etName.text.toString().isNotEmpty()){
            AppEnglishApplication.prefs.saveName(binding.etName.text.toString())
            i += 1
            //guardar el usuario
        }else{
            println("Campo de nombre esta vacío")
            //hacer otra cosa
        }
        if(binding.etUser.text.toString().isNotEmpty()){
            AppEnglishApplication.prefs.saveUser(binding.etUser.text.toString())
            i += 1
        }else{
            println("Campo de usuario esta vacío")
            //hacer otra cosa
        }
        if(binding.etPassword.text.toString().isNotEmpty()){
            AppEnglishApplication.prefs.savePassword(binding.etPassword.text.toString())
            i += 1
        }else{
            println("Campo de contraseña esta vacío")
        }
        if(i == 3){
            goToDetail()

        }else{
            println("Responde todos los campos")
        }
    }

    private fun goToDetail(){
        startActivity(Intent(this, ActivityLogin::class.java))
    }
}

