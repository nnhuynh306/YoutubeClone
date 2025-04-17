package com.example.youtubeclone

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.youtubeclone.app.YoutubeComposeApp
import com.example.youtubeclone.app.rememberAppState
import com.example.youtubeclone.core.components.theme.AppTheme
import com.example.youtubeclone.features.auth.navigation.navigateToLoginScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel: MainActivityViewModel by viewModels()

        val splashScreen = installSplashScreen()

        setContent {
            val mainActivityUiState = viewModel.uiState.collectAsStateWithLifecycle().value

            splashScreen.setKeepOnScreenCondition { mainActivityUiState is MainActivityUiState.Loading }

            if (mainActivityUiState is MainActivityUiState.Loaded) {
                val appState = rememberAppState(
                    isAuthenticated = mainActivityUiState.isAuthenticated,
                )

                AppTheme {
                    YoutubeComposeApp(
                        appState
                    )
                }
            }
        }
    }
}