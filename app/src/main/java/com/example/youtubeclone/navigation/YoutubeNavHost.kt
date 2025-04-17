package com.example.youtubeclone.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import com.example.youtubeclone.app.YoutubeAppState
import com.example.youtubeclone.features.auth.navigation.LoginRoute
import com.example.youtubeclone.features.auth.navigation.loginScreen

@Composable
fun YoutubeNavHost(
    appState: YoutubeAppState
) {
    val navController = appState.navController

    val startDestination = LoginRoute

    NavHost(navController = navController, startDestination = startDestination) {
        loginScreen(
            onNavigateToMainScreen = {

            },
            onNavigateToSignUpScreen = {

            }
        )
    }
}