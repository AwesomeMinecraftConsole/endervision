pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }

    plugins {
        val compose_version: String by settings
        kotlin("multiplatform") version "1.5.21"
        kotlin("jvm") version "1.5.21"
        id("org.jetbrains.compose") version compose_version
    }
}

rootProject.name = "com.uramnoil.awesome_minecraft_console.endervision"


include(":android")
include(":main")
include(":common")
include(":desktop")