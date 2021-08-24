package com.app.demoappjoke.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.app.demoappjoke.domain.usecase.DeleteSavedJokeUseCase
import com.app.demoappjoke.domain.usecase.GetJokeUseCase
import com.app.demoappjoke.domain.usecase.GetSavedJokeUseCase
import com.app.demoappjoke.domain.usecase.SaveJokeUseCase

class JokeViewModelFactory(private val app: Application, private val getJokeUseCase: GetJokeUseCase,
                           private val savedJokeUseCase: SaveJokeUseCase,
                           private val getSavedJokeUseCase: GetSavedJokeUseCase,
                           private val deleteSavedJokeUseCase: DeleteSavedJokeUseCase): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return JokeViewModel(app, getJokeUseCase,savedJokeUseCase,getSavedJokeUseCase,deleteSavedJokeUseCase) as T
    }
}