package com.app.demoappjoke.domain.usecase

import com.app.demoappjoke.data.model.Joke
import com.app.demoappjoke.domain.repository.JokeRepository
import kotlinx.coroutines.flow.Flow

class GetSavedJokeUseCase(private val jokeRepository: JokeRepository) {
    fun execute(): Flow<List<Joke>>{
        return jokeRepository.getSavedJokes()
    }
}