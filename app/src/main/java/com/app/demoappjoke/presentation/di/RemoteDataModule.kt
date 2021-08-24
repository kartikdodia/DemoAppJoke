package com.app.demoappjoke.presentation.di

import com.app.demoappjoke.data.api.JokeAPIService
import com.app.demoappjoke.data.repository.dataSource.JokeRemoteDataSource
import com.app.demoappjoke.data.repository.dataSourceImpl.JokeRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RemoteDataModule {
    @Singleton
    @Provides
    fun provideJokeRemoteDataSource(jokeAPIService: JokeAPIService):JokeRemoteDataSource{
        return JokeRemoteDataSourceImpl(jokeAPIService)
    }
}