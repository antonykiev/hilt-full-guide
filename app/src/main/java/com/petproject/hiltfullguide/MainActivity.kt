package com.petproject.hiltfullguide

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import com.petproject.hiltfullguide.ui.theme.HiltFullGuideTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var repository: Repository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        repository.execute()
        enableEdgeToEdge()
        setContent {
            HiltFullGuideTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { it ->
                    Text(
                        text = "Hello Android!",
                        modifier = Modifier.padding(it)
                    )
                }
            }
        }
    }
}

class Repository @Inject constructor() {
    fun execute() {
        Log.d("Repository", "execute: run")
    }
}