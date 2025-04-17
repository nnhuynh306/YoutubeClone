package com.example.youtubeclone.core.datastore

import com.example.youtubeclone.core.data.security.CryptoManager
import javax.inject.Inject

internal class LocalTokenSerializer @Inject constructor(
    cryptoManager: CryptoManager
): EncryptedSerializer<LocalToken>(cryptoManager) {
    override fun readFromDecryptedBytes(bytes: ByteArray): LocalToken {
        return LocalToken.parseFrom(bytes)
    }

    override fun transformObjectToBytes(t: LocalToken): ByteArray {
        return t.toByteArray()
    }

    override val defaultValue: LocalToken
        get() = LocalToken.getDefaultInstance()
}