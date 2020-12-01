package com.example.endlistingapp.di

import com.example.endlistingapp.MyApp
import com.example.endlistingapp.di.modules.NetworkModule
import com.example.endlistingapp.network.EndClient
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface AppComponent {
    fun inject(myApp: MyApp)
    fun client(): EndClient
}