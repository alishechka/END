package com.example.endlistingapp.di.modules

import com.example.endlistingapp.repository.Repository
import com.example.endlistingapp.repository.RepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@InstallIn(ApplicationComponent::class)
@Module
abstract class RepositoryModule {
    @Binds
    abstract fun bindRepository(repo: RepositoryImpl): Repository
}