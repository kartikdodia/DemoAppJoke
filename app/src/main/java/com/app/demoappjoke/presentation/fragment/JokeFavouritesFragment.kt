package com.app.demoappjoke.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.demoappjoke.MainActivity
import com.app.demoappjoke.R
import com.app.demoappjoke.databinding.FragmentFavouriteJokeBinding
import com.app.demoappjoke.presentation.adapter.JokeAdapter
import com.app.demoappjoke.presentation.viewmodel.JokeViewModel
import com.google.android.material.snackbar.Snackbar

class JokeFavouritesFragment : Fragment()  {
    private lateinit var fragmentFavouriteJokeBinding:FragmentFavouriteJokeBinding
    private lateinit var viewModel: JokeViewModel
    private lateinit var jokeAdapter: JokeAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favourite_joke, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentFavouriteJokeBinding = FragmentFavouriteJokeBinding.bind(view)
        viewModel = (activity as MainActivity).viewModel
        jokeAdapter = (activity as MainActivity).jokeAdapter

        initRecyclerView()

        //Display joke into Recyclerview
        viewModel.getSavedJokes().observe(viewLifecycleOwner,{
            jokeAdapter.differ.submitList(it)
        })


        // Swipe to Delete
        val itemTouchHelperCallback = object : ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP or ItemTouchHelper.DOWN, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT){
            override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean {
                return true
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                val joke = jokeAdapter.differ.currentList[position]
                viewModel.deleteJoke(joke)
                Snackbar.make(view,"Deleted Successfully!", Snackbar.LENGTH_LONG)
                    .apply {
                        setAction("Undo"){
                            viewModel.saveJoke(joke)
                        }
                        show()
                    }
            }
        }

        ItemTouchHelper(itemTouchHelperCallback).apply {
            attachToRecyclerView(fragmentFavouriteJokeBinding.rvSaved)
        }

    }

    private fun initRecyclerView(){
        fragmentFavouriteJokeBinding.rvSaved.apply {
            adapter = jokeAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }

}