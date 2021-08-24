package com.app.demoappjoke.data.repository.dataSourceImpl

import com.app.demoappjoke.data.api.JokeAPIService
import com.app.demoappjoke.data.model.Joke
import com.app.demoappjoke.data.repository.dataSource.JokeRemoteDataSource
import retrofit2.Response

class JokeRemoteDataSourceImpl(private val jokeAPIService: JokeAPIService):JokeRemoteDataSource {
    override suspend fun getJoke(): Response<Joke> {
        return jokeAPIService.getJoke()
    }
}