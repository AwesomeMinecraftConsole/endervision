pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }

    plugins {
        val kotlin_version: String by settings
        val compose_version: String by settings
        val protobuf_gradle_version: String by settings
        kotlin("multiplatform") version kotlin_version
        kotlin("jvm") version kotlin_version
        id("org.jetbrains.compose") version compose_version
        id("com.google.protobuf") version protobuf_gradle_version
    }
}

rootProject.name = "com.uramnoil.awesome_minecraft_console.endervision"

include(":android")
include(":main")
include(":common")
include(":desktop")