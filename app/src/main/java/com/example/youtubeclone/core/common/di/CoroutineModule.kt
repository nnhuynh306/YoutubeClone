package com.example.youtubeclone.core.common.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import javax.inject.Qualifier
import javax.inject.Singleton

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class ApplicationScope

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class Dispatcher(val dispatcherType: DispatcherType)

enum class DispatcherType {
    DEFAULT,
    IO
}

@Module
@InstallIn(SingletonComponent::class)
object CoroutineModule {

    @Provides
    @Singleton
    @ApplicationScope
    fun providesApplicationScope(
        @Dispatcher(DispatcherType.DEFAULT) dispatcher: CoroutineDispatcher
    ): CoroutineScope {
        return CoroutineScope(SupervisorJob() + dispatcher)
    }

    @Provides
    @Dispatcher(DispatcherType.DEFAULT)
    fun providesDispatcherDefault(): CoroutineDispatcher = Dispatchers.Default

    @Provides
    @Dispatcher(DispatcherType.IO)
    fun providesDispatcherIO(): CoroutineDispatcher = Dispatchers.IO
}