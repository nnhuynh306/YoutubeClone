package com.example.youtubeclone.core.data.datasource.local

import com.example.youtubeclone.core.model.TokenData
import com.example.youtubeclone.core.model.UserPreferences
import kotlinx.coroutines.flow.Flow

interface UserLocalDataSource {
    val userPreferencesData: Flow<UserPreferences>
    val tokenData: Flow<TokenData>
    suspend fun updateTheme(theme: String): Boolean
    suspend fun updateTokenData(tokenData: TokenData): Boolean
    suspend fun clearAll(): Boolean
}