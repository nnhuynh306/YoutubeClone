// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    id("com.google.dagger.hilt.android") version "2.56" apply false
    id("com.google.devtools.ksp") version "2.1.20-1.0.31" apply false
    id("com.google.protobuf") version "0.9.4" apply false
    id("org.jetbrains.kotlin.plugin.serialization") version "2.1.20" apply false
}