package com.app.demoappjoke.data.repository

import com.app.demoappjoke.data.model.Joke
import com.app.demoappjoke.data.repository.dataSource.JokeLocalDataSource
import com.app.demoappjoke.data.repository.dataSource.JokeRemoteDataSource
import com.app.demoappjoke.data.util.Resource
import com.app.demoappjoke.domain.repository.JokeRepository
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

class JokeRepositoryImpl(private val jokeRemoteDataSource: JokeRemoteDataSource,
private val jokeLocalDataSource: JokeLocalDataSource):JokeRepository {
    override suspend fun getJoke(): Resource<Joke> {
        return responseToResource(jokeRemoteDataSource.getJoke())
    }

    private fun responseToResource(response: Response<Joke>):Resource<Joke>{
        if(response.isSuccessful){
            response.body()?.let {result->
                return Resource.Success(result)
            }
        }
        return Resource.Error(response.message())
    }

    override suspend fun saveJoke(joke: Joke) {
       jokeLocalDataSource.saveJokeToDB(joke)
    }

    override suspend fun deleteJoke(joke: Joke) {
        return jokeLocalDataSource.deleteJokeFromDB(joke)
    }

    override fun getSavedJokes(): Flow<List<Joke>> {
        return jokeLocalDataSource.getSavedJokes()
    }
}