package com.example.youtubeclone.features.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.protobuf.value

@Composable
fun LoginScreen(
    onNavigateToMainScreen: () -> Unit,
    onNavigateToSignUpScreen: () -> Unit,
) {
    Scaffold { paddingValues ->
        Box(
            Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .wrapContentSize()
        ) {
            Column {
                OutlinedTextField(
                    value = "",
                    onValueChange = {

                    }
                )
            }
        }
    }
}