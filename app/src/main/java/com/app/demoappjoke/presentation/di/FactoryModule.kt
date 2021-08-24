package com.app.demoappjoke.presentation.di

import android.app.Application
import com.app.demoappjoke.domain.usecase.DeleteSavedJokeUseCase
import com.app.demoappjoke.domain.usecase.GetJokeUseCase
import com.app.demoappjoke.domain.usecase.GetSavedJokeUseCase
import com.app.demoappjoke.domain.usecase.SaveJokeUseCase
import com.app.demoappjoke.presentation.viewmodel.JokeViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class FactoryModule {

    @Singleton
    @Provides
    fun provideJokeViewModelFactory(application:Application,getJokeUseCase: GetJokeUseCase,saveJokeUseCase: SaveJokeUseCase,getSavedJokeUseCase: GetSavedJokeUseCase,
    deleteSavedJokeUseCase: DeleteSavedJokeUseCase):JokeViewModelFactory{
            return JokeViewModelFactory(application,getJokeUseCase,saveJokeUseCase,getSavedJokeUseCase,deleteSavedJokeUseCase)
    }
}