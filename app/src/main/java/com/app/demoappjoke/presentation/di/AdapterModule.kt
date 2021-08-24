package com.app.demoappjoke.presentation.di

import com.app.demoappjoke.presentation.adapter.JokeAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AdapterModule {
    @Singleton
    @Provides
    fun provideJokeAdapter():JokeAdapter{
        return JokeAdapter()
    }
}