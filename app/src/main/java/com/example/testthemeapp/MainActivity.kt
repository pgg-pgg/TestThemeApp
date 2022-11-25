package com.example.testthemeapp

import android.content.Context
import android.content.res.Configuration
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatDelegate

class MainActivity : BaseAppCompatActivity() {
    override fun attachBaseContext(newBase: Context?) {
//        delegate.localNightMode = AppCompatDelegate.MODE_NIGHT_YES
        super.attachBaseContext(newBase)
    }

    private val handler = Handler()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        handler.postDelayed({
            findViewById<View>(R.id.iv_test).setBackgroundColor(if (isContextModeNight(this)) getColor(R.color.teal_200) else getColor(R.color.purple_200))
        }, 5000)
    }

    private fun isContextModeNight(context: Context): Boolean {
        return (context.resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK) == Configuration.UI_MODE_NIGHT_YES
    }
}