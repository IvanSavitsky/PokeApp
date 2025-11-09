package com.example.kotlinapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlinapp.databinding.ActivityMainBinding
import com.example.shared.JokeViewModel
import dev.icerock.moko.mvvm.getViewModel
import dev.icerock.moko.mvvm.livedata.bindText

//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            Main()
//        }
//    }
//}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel: JokeViewModel = getViewModel { JokeViewModel() }

        binding.jokeText.bindText(this, viewModel.jokeText)

        binding.randomBtn.setOnClickListener { viewModel.onRandomJokePressed() }
    }
}