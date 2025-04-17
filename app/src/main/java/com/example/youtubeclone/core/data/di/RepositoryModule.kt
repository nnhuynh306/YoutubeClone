package com.example.youtubeclone.core.data.di

import com.example.youtubeclone.core.data.repository.DefaultUserRepository
import com.example.youtubeclone.core.data.repository.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppScopeRepositoryModule {

    @Singleton
    @Binds
    internal abstract fun bindUserRepository(
        userRepository: DefaultUserRepository
    ): UserRepository
}

@Module
@InstallIn(ViewModelComponent::class)
abstract class ViewModelScopeRepositoryModule {

}