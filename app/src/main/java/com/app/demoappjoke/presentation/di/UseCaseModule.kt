package com.app.demoappjoke.presentation.di

import com.app.demoappjoke.domain.repository.JokeRepository
import com.app.demoappjoke.domain.usecase.DeleteSavedJokeUseCase
import com.app.demoappjoke.domain.usecase.GetJokeUseCase
import com.app.demoappjoke.domain.usecase.GetSavedJokeUseCase
import com.app.demoappjoke.domain.usecase.SaveJokeUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Singleton
    @Provides
    fun provideGetJokeUseCase(jokeRepository: JokeRepository):GetJokeUseCase{
        return GetJokeUseCase(jokeRepository)
    }

    @Singleton
    @Provides
    fun provideSaveJokeUseCase(jokeRepository: JokeRepository):SaveJokeUseCase{
        return SaveJokeUseCase(jokeRepository)
    }

    @Singleton
    @Provides
    fun provideGetSavedJokeUseCase(jokeRepository: JokeRepository):GetSavedJokeUseCase{
        return GetSavedJokeUseCase(jokeRepository)
    }

    @Singleton
    @Provides
    fun provideDeleteSavedJokeUseCase(jokeRepository: JokeRepository):DeleteSavedJokeUseCase{
        return DeleteSavedJokeUseCase(jokeRepository)
    }
}