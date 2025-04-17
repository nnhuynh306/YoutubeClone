package com.example.youtubeclone.core.datastore

import androidx.datastore.core.DataStore
import com.example.youtubeclone.core.data.datasource.local.UserLocalDataSource
import com.example.youtubeclone.core.datastore.model.toDomainModel
import com.example.youtubeclone.core.datastore.model.toLocalDataModel
import com.example.youtubeclone.core.model.Token
import com.example.youtubeclone.core.model.TokenData
import com.example.youtubeclone.core.model.UserPreferences
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

internal class DefaultUserLocalDataSource @Inject constructor(
    private val userPreferencesDataStore: DataStore<LocalUserPreferences>,
    private val tokenDataStore: DataStore<LocalToken>
): UserLocalDataSource {

    override val userPreferencesData = userPreferencesDataStore.data.map {
        it.toDomainModel()
    }

    override val tokenData: Flow<TokenData> = tokenDataStore.data.map {
        TokenData(
            accessToken = Token(
                token = it.accessToken,
                expireDate = it.accessTokenExpireDate
            ),
            refreshToken = Token(
                token = it.refreshToken,
                expireDate = it.refreshTokenExpireDate
            )
        )
    }

    override suspend fun updateTheme(theme: String): Boolean {
        try {
            userPreferencesDataStore.updateData { currentPreferences ->
                currentPreferences.toBuilder()
                    .setTheme(theme)
                    .build()
            }
            return true
        } catch (ex: Exception) {
            ex.printStackTrace()
            return false
        }
    }

    override suspend fun updateTokenData(tokenData: TokenData): Boolean {
        return updateTokenData(tokenData.toLocalDataModel())
    }

    private suspend fun updateTokenData(localToken: LocalToken): Boolean {
        try {
            tokenDataStore.updateData {
                localToken
            }
            return true
        } catch (ex: Exception) {
            ex.printStackTrace()
            return false
        }
    }

    private suspend fun clearToken(): Boolean {
        return updateTokenData(LocalToken.getDefaultInstance())
    }

    private suspend fun clearUserPreferences(): Boolean {
        return updateTheme("")
    }

    override suspend fun clearAll(): Boolean {
        clearUserPreferences()
        clearToken()
        return true
    }
}