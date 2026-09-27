package com.example.amphibians

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.amphibians.ui.screens.HomeScreen
import com.example.amphibians.ui.screens.AmphibiansViewModel
import com.example.amphibians.ui.theme.AmphibiansTheme

class MainActivity : ComponentActivity() {

    private val viewModel: AmphibiansViewModel by viewModels { AmphibiansViewModel.Factory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AmphibiansTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    Scaffold { innerPadding ->
                        HomeScreen(
                            amphibiansUiState = viewModel.amphibiansUiState,
                            retryAction = viewModel::getAmphibians,
                            modifier = Modifier.padding(innerPadding)
                        )
                    }
                }
            }
        }
    }
}