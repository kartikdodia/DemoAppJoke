package com.app.demoappjoke.presentation.di

import com.app.demoappjoke.data.repository.JokeRepositoryImpl
import com.app.demoappjoke.data.repository.dataSource.JokeLocalDataSource
import com.app.demoappjoke.data.repository.dataSource.JokeRemoteDataSource
import com.app.demoappjoke.domain.repository.JokeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {
    @Singleton
    @Provides
    fun provideJokeRepository(jokeRemoteDataSource: JokeRemoteDataSource,jokeLocalDataSource: JokeLocalDataSource):JokeRepository{
        return JokeRepositoryImpl(jokeRemoteDataSource,jokeLocalDataSource)
    }
}