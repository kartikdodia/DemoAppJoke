package com.app.demoappjoke.data.repository.dataSource

import com.app.demoappjoke.data.model.Joke
import retrofit2.Response

interface JokeRemoteDataSource {
    suspend fun getJoke():Response<Joke>
}