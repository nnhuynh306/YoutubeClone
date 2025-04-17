package com.example.youtubeclone.core.datastore.di

import com.example.youtubeclone.core.datastore.DefaultUserLocalDataSource
import com.example.youtubeclone.core.data.datasource.local.UserLocalDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {
    @Binds
    @Singleton
    internal abstract fun bindsUserPreferencesDataSource(
        userPreferencesLocalDataSource: DefaultUserLocalDataSource
    ): UserLocalDataSource
}