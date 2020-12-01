package com.example.endlistingapp.di.modules

import com.example.endlistingapp.repository.Repository
import com.example.endlistingapp.repository.RepositoryImpl
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule {
    @Binds
    abstract fun bindRepository(repo: RepositoryImpl): Repository
}