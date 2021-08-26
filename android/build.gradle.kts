plugins {
    id("org.jetbrains.compose")
    id("com.android.application")
    kotlin("android")
}

group = "com.uramnoil"
version = "0.1"

repositories {
    google()
}

dependencies {
    implementation(project(":common"))
}

android {
    compileSdkVersion(30)
    defaultConfig {
        applicationId = "com.uramnoil.android"
        minSdkVersion(24)
        targetSdkVersion(30)
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}