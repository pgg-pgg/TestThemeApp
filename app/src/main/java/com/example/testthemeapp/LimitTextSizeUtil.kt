package com.example.testthemeapp

import android.content.res.Resources

object LimitTextSizeUtil {
    /**
     * 限制应用内字体大小不随系统字体大小改变
     */
    fun limitTextSize(resources: Resources): Resources {
        val newConfig = resources.configuration
        val displayMetrics = resources.displayMetrics

        if (newConfig.fontScale != 1f) {
            newConfig.fontScale = 1f
            displayMetrics.scaledDensity = displayMetrics.density * newConfig.fontScale
            resources.updateConfiguration(newConfig, displayMetrics)
        }
        return resources
    }
}
