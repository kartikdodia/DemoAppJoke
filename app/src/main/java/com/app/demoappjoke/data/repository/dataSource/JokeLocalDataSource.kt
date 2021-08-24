package com.app.demoappjoke.data.repository.dataSource

import com.app.demoappjoke.data.model.Joke
import kotlinx.coroutines.flow.Flow

interface JokeLocalDataSource {
    suspend fun saveJokeToDB(joke: Joke)

    fun getSavedJokes():Flow<List<Joke>>

    suspend fun deleteJokeFromDB(joke: Joke)
}