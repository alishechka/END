package com.example.endlistingapp

import android.app.Application
import android.content.Context
import com.example.endlistingapp.di.AppComponent
import com.example.endlistingapp.di.DaggerAppComponent
import com.example.endlistingapp.di.modules.NetworkModule
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

    fun component(): AppComponent {
        return DaggerAppComponent.builder()
            .networkModule(NetworkModule())
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        component()
        Timber.plant(Timber.DebugTree())
    }
}