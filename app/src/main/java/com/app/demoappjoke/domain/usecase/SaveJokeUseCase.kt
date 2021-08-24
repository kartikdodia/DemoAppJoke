package com.app.demoappjoke.domain.usecase

import com.app.demoappjoke.data.model.Joke
import com.app.demoappjoke.domain.repository.JokeRepository

class SaveJokeUseCase(private val jokeRepository: JokeRepository) {
    suspend fun execute(joke: Joke) = jokeRepository.saveJoke(joke)
}