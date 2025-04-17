package com.example.youtubeclone.core.data.di

import com.example.youtubeclone.core.data.security.CryptoManager
import com.example.youtubeclone.core.data.security.CryptoManagerImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class SecurityModule {
    @Singleton
    @Binds
    internal abstract fun bindCryptoManager(
        cryptoManager: CryptoManagerImpl
    ): CryptoManager
}