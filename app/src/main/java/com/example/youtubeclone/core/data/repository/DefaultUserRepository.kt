package com.example.youtubeclone.core.data.repository

import androidx.datastore.dataStore
import com.example.youtubeclone.core.data.datasource.local.UserLocalDataSource
import com.example.youtubeclone.core.model.Token
import com.example.youtubeclone.core.model.TokenData
import com.example.youtubeclone.core.model.UserPreferences
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

internal class DefaultUserRepository @Inject constructor(
    private val userLocalDataSource: UserLocalDataSource,
): UserRepository {
    override fun getUserReferencesFlow(): Flow<UserPreferences> {
        return userLocalDataSource.userPreferencesData
    }

    private suspend fun isExistValidToken(tokenData: TokenData?): Boolean {
        try {
            val savedToken = tokenData ?: getTokenData()
            return savedToken?.let {
                return if (it.accessToken.isValid()) {
                    true
                } else {
                    it.refreshToken.isValid()
                }
            } ?: false
        } catch (ex: Exception) {
            ex.printStackTrace()
            return false
        }
    }


    override suspend fun getAccessToken(): Token? {
        return getTokenData()?.accessToken
    }

    private suspend fun getTokenData(): TokenData? {
        return userLocalDataSource.tokenData.firstOrNull()
    }

    override suspend fun tryRefreshToken(): Boolean {
        return true
    }

    override fun getAuthenticatedFlow(): Flow<Boolean> {
        return userLocalDataSource.tokenData.map {
            isExistValidToken(it)
        }
    }
}