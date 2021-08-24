package com.app.demoappjoke.data.api

import com.app.demoappjoke.data.model.Joke
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface JokeAPIService {
    @Headers("Accept: application/json")
    @GET("/")
    suspend fun getJoke(): Response<Joke>
}