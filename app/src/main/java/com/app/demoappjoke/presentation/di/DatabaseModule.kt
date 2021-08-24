package com.app.demoappjoke.presentation.di

import android.app.Application
import androidx.room.Room
import com.app.demoappjoke.data.db.JokeDAO
import com.app.demoappjoke.data.db.JokeDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    @Provides
    @Singleton
    fun providesJokeDatabase(application: Application):JokeDatabase{
        return Room.databaseBuilder(application,JokeDatabase::class.java,"joke_db").fallbackToDestructiveMigration().build()
    }

    @Provides
    @Singleton
    fun providesJokeDAO(jokeDatabase: JokeDatabase):JokeDAO{
        return jokeDatabase.getJokeDAO()
    }
}