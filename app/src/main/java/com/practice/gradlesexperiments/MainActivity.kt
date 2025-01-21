package com.practice.gradlesexperiments

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Retrieve the base URL from BuildConfig and log it for verification
        val baseUrl: String = BuildConfig.BASE_URL
        Log.d("mvv", "Base URL: $baseUrl")

        val versionName: String = BuildConfig.VERSION_NAME
        Log.d("mvv", "Version Name: $versionName")

        val versionCode: Int = BuildConfig.VERSION_CODE
        Log.d("mvv", "Version Code: $versionCode")

    }
}