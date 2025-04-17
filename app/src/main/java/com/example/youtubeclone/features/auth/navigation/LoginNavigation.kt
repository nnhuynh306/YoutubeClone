package com.example.youtubeclone.features.auth.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.youtubeclone.features.auth.LoginScreen
import kotlinx.serialization.Serializable

@Serializable
object LoginRoute

fun NavController.navigateToLoginScreen() {
    navigate(LoginRoute)
}

fun NavGraphBuilder.loginScreen(
    onNavigateToMainScreen: () -> Unit,
    onNavigateToSignUpScreen: () -> Unit,
) {
    composable<LoginRoute> {
        LoginScreen(
            onNavigateToMainScreen = onNavigateToMainScreen,
            onNavigateToSignUpScreen = onNavigateToSignUpScreen,
        )
    }
}