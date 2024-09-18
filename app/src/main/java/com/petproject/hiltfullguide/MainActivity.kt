package com.petproject.hiltfullguide

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import com.petproject.hiltfullguide.repository.Repository
import com.petproject.hiltfullguide.ui.theme.HiltFullGuideTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import javax.inject.Named


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: ViewModelHilt by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.userName()
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