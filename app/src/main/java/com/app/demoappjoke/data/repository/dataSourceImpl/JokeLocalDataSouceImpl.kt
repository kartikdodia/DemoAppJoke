package com.app.demoappjoke.data.repository.dataSourceImpl

import com.app.demoappjoke.data.db.JokeDAO
import com.app.demoappjoke.data.model.Joke
import com.app.demoappjoke.data.repository.dataSource.JokeLocalDataSource
import kotlinx.coroutines.flow.Flow

class JokeLocalDataSouceImpl(private val jokeDAO: JokeDAO):JokeLocalDataSource {
    override suspend fun saveJokeToDB(joke: Joke) {
       jokeDAO.insert(joke)
    }

    override fun getSavedJokes(): Flow<List<Joke>> {
        return jokeDAO.getAllJokes()
    }

    override suspend fun deleteJokeFromDB(joke: Joke) {
        return jokeDAO.deleteJoke(joke)
    }
}