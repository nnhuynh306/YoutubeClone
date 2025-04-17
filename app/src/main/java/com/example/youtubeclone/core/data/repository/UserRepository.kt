package com.example.youtubeclone.core.data.repository

import com.example.youtubeclone.core.model.Token
import com.example.youtubeclone.core.model.UserPreferences
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    fun getUserReferencesFlow(): Flow<UserPreferences>
    suspend fun getAccessToken(): Token?
    suspend fun tryRefreshToken(): Boolean
    fun getAuthenticatedFlow(): Flow<Boolean>
}