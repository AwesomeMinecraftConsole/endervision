import org.jetbrains.compose.compose
import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    kotlin("jvm")
    id("org.jetbrains.compose")
}

group = "com.uramnoil"
version = "0.1"

dependencies {
    val kodein_version: String by project
    implementation(project(":common"))
    implementation(compose.desktop.currentOs)
    implementation("org.kodein.di:kodein-di:${kodein_version}")
    implementation("org.kodein.di:kodein-di-framework-compose:${kodein_version}")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.1")
}

compose.desktop {
    application {
        mainClass = "MainKt"
        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "jvm"
            packageVersion = "1.0.0"
        }
    }
}