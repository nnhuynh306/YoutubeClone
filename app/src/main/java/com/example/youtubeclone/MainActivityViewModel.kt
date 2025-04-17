package com.example.youtubeclone

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.youtubeclone.core.data.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val userRepository: UserRepository
): ViewModel() {
    val uiState = combine(
        userRepository.getUserReferencesFlow(),
        userRepository.getAuthenticatedFlow()
    ) { userPreferences, isAuthenticated ->
        MainActivityUiState.Loaded(userPreferences.theme, isAuthenticated)
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(),
        initialValue = MainActivityUiState.Loading
    )
}

sealed interface MainActivityUiState {
    object Loading: MainActivityUiState
    data class Loaded(val theme: String, val isAuthenticated: Boolean): MainActivityUiState
}