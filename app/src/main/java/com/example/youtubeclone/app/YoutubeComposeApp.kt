package com.example.youtubeclone.app

import androidx.compose.runtime.Composable
import com.example.youtubeclone.navigation.YoutubeNavHost

@Composable
fun YoutubeComposeApp(
    appState: YoutubeAppState
) {
    YoutubeNavHost(
        appState = appState
    )
}
