package com.example.youtubeclone.core.datastore.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.core.DataStoreFactory
import androidx.datastore.dataStoreFile
import com.example.youtubeclone.core.common.di.ApplicationScope
import com.example.youtubeclone.core.common.di.Dispatcher
import com.example.youtubeclone.core.common.di.DispatcherType
import com.example.youtubeclone.core.datastore.LocalToken
import com.example.youtubeclone.core.datastore.LocalTokenSerializer
import com.example.youtubeclone.core.datastore.LocalUserPreferences
import com.example.youtubeclone.core.datastore.UserPreferencesSerializer
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataStoreModule {
    @Provides
    @Singleton
    internal fun providesUserPreferencesDataStore(
        @ApplicationScope scope: CoroutineScope,
        @ApplicationContext context: Context,
        @Dispatcher(DispatcherType.IO) dispatcher: CoroutineDispatcher,
        userPreferencesSerializer: UserPreferencesSerializer
    ): DataStore<LocalUserPreferences> {
        return DataStoreFactory.create(
            serializer = userPreferencesSerializer,
            scope = CoroutineScope(scope.coroutineContext + dispatcher),
            produceFile = {
                context.dataStoreFile("user_preferences.pb")
            }
        )
    }

    @Provides
    @Singleton
    internal fun providesTokenDataStore(
        @ApplicationContext context: Context,
        @ApplicationScope scope: CoroutineScope,
        @Dispatcher(DispatcherType.IO) dispatcher: CoroutineDispatcher,
        tokenSerializer: LocalTokenSerializer
    ): DataStore<LocalToken> {
        return DataStoreFactory.create(
            serializer = tokenSerializer,
            scope = CoroutineScope(scope.coroutineContext + dispatcher),
            produceFile = {
                context.dataStoreFile("token.pb")
            }
        )
    }
}
