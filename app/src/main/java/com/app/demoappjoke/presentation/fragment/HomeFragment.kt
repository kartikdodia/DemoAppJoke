package com.app.demoappjoke.presentation.fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.app.demoappjoke.MainActivity
import com.app.demoappjoke.R
import com.app.demoappjoke.data.model.Joke
import com.app.demoappjoke.data.util.Resource
import com.app.demoappjoke.databinding.FragmentHomeBinding
import com.app.demoappjoke.presentation.viewmodel.JokeViewModel
import com.google.android.material.snackbar.Snackbar

class HomeFragment : Fragment() {
    private lateinit var viewModel: JokeViewModel
    private lateinit var fragmentHomeBinding: FragmentHomeBinding
    private lateinit var joke:Joke

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragmentHomeBinding = FragmentHomeBinding.bind(view)
        viewModel = (activity as MainActivity).viewModel

        getJoke()

        fragmentHomeBinding.favouriteButton.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_jokeFavouritesFragment)
        }

        fragmentHomeBinding.addButton.setOnClickListener {
            viewModel.saveJoke(joke)
            Snackbar.make(view,"Saved successfully!",Snackbar.LENGTH_LONG).show()
        }

        fragmentHomeBinding.jokeButton.setOnClickListener {
                getJoke()
        }

        fragmentHomeBinding.shareJokeButton.setOnClickListener {
            shareJokeByText()
        }
    }

    private fun shareJokeByText(){
        val shareIntent = Intent()
        shareIntent.action = Intent.ACTION_SEND
        shareIntent.type="text/plain"
        shareIntent.putExtra(Intent.EXTRA_TEXT, joke.Joke)
        startActivity(Intent.createChooser(shareIntent,getString(R.string.share_joke_by_text)))
    }

    private fun getJoke(){
        viewModel.getJoke()

        viewModel.randomJoke.observe(viewLifecycleOwner,{response->
           when(response){
                is Resource.Success->{

                    response.data?.let {
                        Log.d("MYTAG","came here ${it.Joke}")
                        fragmentHomeBinding.jokeText.text = it.Joke
                        joke = it
                    }
                }
                is Resource.Error->{
                    response.message?.let {
                        Log.d("ERROR : ",it)
                        Toast.makeText(activity,"An error occurred : $it", Toast.LENGTH_LONG).show()
                    }
                }
            }
        })
    }
}