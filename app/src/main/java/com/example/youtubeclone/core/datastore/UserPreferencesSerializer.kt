package com.example.youtubeclone.core.datastore

import com.example.youtubeclone.core.data.security.CryptoManager
import javax.inject.Inject

internal class UserPreferencesSerializer @Inject constructor(cryptoManager: CryptoManager)
    : EncryptedSerializer<LocalUserPreferences>(cryptoManager) {

    override val defaultValue: LocalUserPreferences = LocalUserPreferences.getDefaultInstance()

    override fun readFromDecryptedBytes(bytes: ByteArray): LocalUserPreferences {
        return LocalUserPreferences.parseFrom(bytes)
    }

    override fun transformObjectToBytes(t: LocalUserPreferences): ByteArray {
        return t.toByteArray()
    }

}