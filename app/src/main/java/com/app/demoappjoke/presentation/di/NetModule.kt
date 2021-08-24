package com.app.demoappjoke.presentation.di

import android.util.Log
import com.app.demoappjoke.data.api.JokeAPIService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
     val request = Retrofit.Builder()
     .addConverterFactory(GsonConverterFactory.create())
     .baseUrl("https://icanhazdadjoke.com")
     .build()

        Log.e("request value : ",request.toString()+"   "+request.baseUrl()+"   ")
        return request
    }

    @Singleton
    @Provides
    fun provideJokeAPIService(retrofit: Retrofit):JokeAPIService{
        return retrofit.create(JokeAPIService::class.java)
    }

}