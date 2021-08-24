package com.app.demoappjoke.presentation.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.app.demoappjoke.data.model.Joke
import com.app.demoappjoke.databinding.JokeListItemBinding

class JokeAdapter:RecyclerView.Adapter<JokeAdapter.JokeViewHolder>() {
    private val callback = object : DiffUtil.ItemCallback<Joke>(){
        override fun areItemsTheSame(oldItem: Joke, newItem: Joke): Boolean {
            return oldItem.Joke == newItem.Joke
        }
        override fun areContentsTheSame(oldItem: Joke, newItem: Joke): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this,callback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JokeViewHolder {
        val binding = JokeListItemBinding
            .inflate(LayoutInflater.from(parent.context),parent,false)
        return JokeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: JokeViewHolder, position: Int) {
        val joke = differ.currentList[position]
        holder.bind(joke)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    inner class JokeViewHolder(
        val binding:JokeListItemBinding):
        RecyclerView.ViewHolder(binding.root){
        fun bind(joke: Joke){
            Log.i("MYTAG","came here ${joke.Joke}")
            binding.jokeTextOne.text = joke.Joke

        }
    }
}