package com.app.demoappjoke.data.db

import androidx.room.*
import com.app.demoappjoke.data.model.Joke
import kotlinx.coroutines.flow.Flow

@Dao
interface JokeDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(joke: Joke)

    @Query("SELECT * FROM jokes")
    fun getAllJokes(): Flow<List<Joke>>

    @Delete
    suspend fun deleteJoke(joke: Joke)


}