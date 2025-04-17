package com.example.youtubeclone.app

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.CoroutineScope

@Composable
fun rememberAppState(
    navController: NavHostController = rememberNavController(),
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    isAuthenticated: Boolean = false
): YoutubeAppState {
    return remember(
        navController,
        coroutineScope
    ) {
        YoutubeAppState(
            navController = navController,
            coroutineScope = coroutineScope,
            isAuthenticated = isAuthenticated
        )
    }
}

@Stable
data class YoutubeAppState(
    val navController: NavHostController,
    val coroutineScope: CoroutineScope,
    val isAuthenticated: Boolean
) {

}