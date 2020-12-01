package com.example.endlistingapp

import android.app.Application
import android.content.Context
import timber.log.Timber

class MyApp : Application() {

    init {
        instance = this
    }

    companion object {
        private var instance: MyApp? = null

        fun applicationContext(): Context {
            return instance!!.applicationContext
        }
    }

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}