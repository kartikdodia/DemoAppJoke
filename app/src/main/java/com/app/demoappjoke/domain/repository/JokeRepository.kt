package com.app.demoappjoke.domain.repository

import com.app.demoappjoke.data.model.Joke
import com.app.demoappjoke.data.util.Resource
import kotlinx.coroutines.flow.Flow

interface JokeRepository {
    suspend fun getJoke():Resource<Joke>
    suspend fun saveJoke(joke: Joke)
    suspend fun deleteJoke(joke: Joke)
    fun getSavedJokes(): Flow<List<Joke>>
}