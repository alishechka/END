package com.example.endlistingapp.di

import com.example.endlistingapp.MainActivity
import com.example.endlistingapp.di.modules.RepositoryModule
import com.example.endlistingapp.di.modules.ViewModelModule
import dagger.Component

@ActivityScope
@Component(
    modules = [RepositoryModule::class, ViewModelModule::class],
    dependencies = [AppComponent::class]
)
interface ViewModelComponent {
    fun inject(mainActivity: MainActivity)

}