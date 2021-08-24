package com.app.demoappjoke.domain.usecase

import com.app.demoappjoke.data.model.Joke
import com.app.demoappjoke.data.util.Resource
import com.app.demoappjoke.domain.repository.JokeRepository

class GetJokeUseCase(private val jokeRepository: JokeRepository) {

    suspend fun execute():Resource<Joke>{
        return jokeRepository.getJoke()
    }
}