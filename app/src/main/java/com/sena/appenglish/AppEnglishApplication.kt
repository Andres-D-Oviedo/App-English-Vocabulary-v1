package com.sena.appenglish
import android.app.Application

class AppEnglishApplication: Application() {

   companion object{
       lateinit var prefs:Prefs
   }

    override fun onCreate() {
        super.onCreate()
        prefs = Prefs(applicationContext)

    }
}