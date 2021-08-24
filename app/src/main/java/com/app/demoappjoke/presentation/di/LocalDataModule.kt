package com.app.demoappjoke.presentation.di

import com.app.demoappjoke.data.db.JokeDAO
import com.app.demoappjoke.data.repository.dataSource.JokeLocalDataSource
import com.app.demoappjoke.data.repository.dataSourceImpl.JokeLocalDataSouceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class LocalDataModule {
    @Provides
    @Singleton
    fun provideLocalDataSource(jokeDAO: JokeDAO):JokeLocalDataSource{
        return JokeLocalDataSouceImpl(jokeDAO)
    }
}