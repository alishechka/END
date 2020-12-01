package com.example.endlistingapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val con: Context = MyApp.applicationContext()
        Timber.d(con.toString())


    }
}