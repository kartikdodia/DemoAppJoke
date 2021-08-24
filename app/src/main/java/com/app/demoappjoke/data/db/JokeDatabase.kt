package com.app.demoappjoke.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.app.demoappjoke.data.model.Joke

@Database(
    entities = [Joke::class],
    version = 1,
    exportSchema = false
)
abstract class JokeDatabase:RoomDatabase() {
    abstract fun getJokeDAO():JokeDAO
}
