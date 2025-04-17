package com.example.youtubeclone.features.auth

import androidx.lifecycle.ViewModel
import com.example.youtubeclone.core.data.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginScreenViewModel @Inject constructor(
    private val userRepository: UserRepository
): ViewModel()
{

}

