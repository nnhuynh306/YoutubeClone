package com.example.youtubeclone.core.datastore

import androidx.datastore.core.CorruptionException
import androidx.datastore.core.Serializer
import com.example.youtubeclone.core.data.security.CryptoManager
import java.io.InputStream
import java.io.OutputStream

internal abstract class EncryptedSerializer<T>(val cryptoManager: CryptoManager): Serializer<T> {
    override suspend fun readFrom(input: InputStream): T {
        try {
            return readFromDecryptedBytes(bytes = cryptoManager.decrypt(inputStream = input))
        } catch (ex: Exception) {
            throw CorruptionException("Cannot read proto.", ex)
        }
    }

    override suspend fun writeTo(t: T, output: OutputStream) {
        cryptoManager.encrypt(transformObjectToBytes(t), output)
    }

    abstract fun readFromDecryptedBytes(bytes: ByteArray): T
    abstract fun transformObjectToBytes(t: T): ByteArray
}