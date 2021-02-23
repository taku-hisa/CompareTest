package com.example.comparetest

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.comparetest.databinding.ActivityMainBinding
import com.example.comparetest.db.Word

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel : MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.getItem.observe( this, Observer {
            binding.recyclerView.apply{
                layoutManager =
                    when {
                        resources.configuration.orientation
                                == Configuration.ORIENTATION_PORTRAIT
                        -> GridLayoutManager(context, 2)
                        else
                        -> GridLayoutManager(context, 4)
                    }
                adapter = wordAdapter(context,it)
            }
        })

        binding.button.setOnClickListener {
            val wordText = binding.edText.text.toString()
            val word = Word(0 , wordText)
            viewModel.insertWord(word)
        }
    }
}