package com.app.demoappjoke.presentation.viewmodel

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.util.Log
import androidx.lifecycle.*
import com.app.demoappjoke.data.model.Joke
import com.app.demoappjoke.data.util.Resource
import com.app.demoappjoke.domain.usecase.DeleteSavedJokeUseCase
import com.app.demoappjoke.domain.usecase.GetJokeUseCase
import com.app.demoappjoke.domain.usecase.GetSavedJokeUseCase
import com.app.demoappjoke.domain.usecase.SaveJokeUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.lang.Exception

class JokeViewModel(private val app: Application, private val getJokeUseCase: GetJokeUseCase,
                    private val savedJokeUseCase: SaveJokeUseCase,
                    private val getSavedJokeUseCase: GetSavedJokeUseCase,
                    private val deleteSavedJokeUseCase: DeleteSavedJokeUseCase):AndroidViewModel(app) {
    val randomJoke : MutableLiveData<Resource<Joke>>  = MutableLiveData()

    fun getJoke() =  viewModelScope.launch(Dispatchers.IO) {
        randomJoke.postValue(Resource.Loading())
        try{
            if(isNetworkAvailable(app)) {
                val apiResult = getJokeUseCase.execute()
                Log.d("RESULT VALUES ", getJokeUseCase.execute().message.toString())
                randomJoke.postValue(apiResult)
            }else{
                randomJoke.postValue(Resource.Error("Internet is not available"))
            }
        }catch (e: Exception){
            Log.d("ERROR  : ",e.message.toString())
           randomJoke.postValue(Resource.Error(e.message.toString()))
        }
    }

    private fun isNetworkAvailable(context: Context?):Boolean{
        if (context == null) return false
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            val capabilities = connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
            if (capabilities != null) {
                when {
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> {
                        return true
                    }
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> {
                        return true
                    }
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> {
                        return true
                    }
                }
            }
        } else {
            val activeNetworkInfo = connectivityManager.activeNetworkInfo
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected) {
                return true
            }
        }
        return false
    }

    //LocalData
    fun saveJoke(joke: Joke) = viewModelScope.launch {
        savedJokeUseCase.execute(joke)
    }

    fun getSavedJokes() = liveData{
        getSavedJokeUseCase.execute().collect {
            emit(it)
        }
    }

    fun deleteJoke(joke: Joke) = viewModelScope.launch {
        deleteSavedJokeUseCase.execute(joke)
    }
}