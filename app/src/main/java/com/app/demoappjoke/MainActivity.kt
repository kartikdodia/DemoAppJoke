package com.app.demoappjoke

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.app.demoappjoke.data.util.Resource
import com.app.demoappjoke.databinding.ActivityMainBinding
import com.app.demoappjoke.presentation.adapter.JokeAdapter
import com.app.demoappjoke.presentation.viewmodel.JokeViewModel
import com.app.demoappjoke.presentation.viewmodel.JokeViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: JokeViewModelFactory
    @Inject
    lateinit var jokeAdapter: JokeAdapter
    lateinit var viewModel: JokeViewModel
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this,factory).get(JokeViewModel::class.java)
    }

}