package com.example.endlistingapp.di.modules

import androidx.lifecycle.ViewModelProvider
import com.example.endlistingapp.MainActivity
import com.example.endlistingapp.MainViewModel
import com.example.endlistingapp.MainViewModelFactory
import com.example.endlistingapp.di.ActivityScope
import com.example.endlistingapp.repository.Repository
import dagger.Module
import dagger.Provides

@Module
class ViewModelModule(private val activity: MainActivity) {

    @Provides
    @ActivityScope
    fun provideViewModel(factory: MainViewModelFactory): MainViewModel {
        return ViewModelProvider(activity, factory).get(MainViewModel::class.java)
    }

    @Provides
    @ActivityScope
    fun provideFactory(repository: Repository): MainViewModelFactory {
        return MainViewModelFactory(repository)
    }
}