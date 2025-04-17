package com.example.youtubeclone.core.datastore.model

import com.example.youtubeclone.core.datastore.LocalToken
import com.example.youtubeclone.core.model.Token
import com.example.youtubeclone.core.model.TokenData

fun LocalToken.toDomainModel(): TokenData {
    return TokenData(
        accessToken = Token(
            token = accessToken,
            expireDate = accessTokenExpireDate
        ),
        refreshToken = Token(
            token = refreshToken,
            expireDate = refreshTokenExpireDate
        )
    )
}

fun TokenData.toLocalDataModel(): LocalToken {
    val builder = LocalToken.newBuilder()
    builder.accessToken = accessToken.token
    builder.accessTokenExpireDate = accessToken.expireDate
    builder.refreshToken = refreshToken.token
    builder.refreshTokenExpireDate = refreshToken.expireDate
    return builder.build()
}