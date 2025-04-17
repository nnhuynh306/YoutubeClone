package com.example.youtubeclone.core.model

data class Token(
    val token: String,
    val expireDate: String,
) {
    fun isValid(): Boolean {
        return token.isNotBlank() && isNotExpired()
    }

    fun isNotExpired(): Boolean {
        return false
    }
}

data class TokenData(
    val accessToken: Token,
    val refreshToken: Token
)