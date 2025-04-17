package com.example.youtubeclone.core.datastore.model

import com.example.youtubeclone.core.datastore.LocalToken
import com.example.youtubeclone.core.datastore.LocalUserPreferences
import com.example.youtubeclone.core.model.UserPreferences

fun LocalUserPreferences.toDomainModel(): UserPreferences {
    return UserPreferences(theme = theme)
}