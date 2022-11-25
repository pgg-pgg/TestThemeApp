package com.example.testthemeapp

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate

class TestApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }
}