pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }

    plugins {
        kotlin("multiplatform") version "1.5.21"
        kotlin("jvm") version "1.5.21"
        id("org.jetbrains.compose") version "1.0.0-alpha3"
    }
}
rootProject.name = "endervision"


include(":android")
include(":desktop")
include(":common")
include(":desktopimpl")

object Properties {
    object Version {
        const val kodein = "7.2.0"
    }
}