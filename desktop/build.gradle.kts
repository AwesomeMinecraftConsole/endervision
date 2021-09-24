import com.google.protobuf.gradle.*
import org.jetbrains.compose.compose
import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    kotlin("jvm")
    id("org.jetbrains.compose")
    id("com.google.protobuf")
}

group = "com.uramnoil"
version = "0.1"

val protobuf_version: String by project
val grpc_version: String by project
val grpc_kotlin_version: String by project

dependencies {
    val kotlin_version: String by project
    val napier_version: String by project
    val coroutines_version: String by project
    val kodein_version: String by project

    implementation(project(":common"))
    implementation(compose.desktop.currentOs)

    implementation("io.github.aakira:napier:$napier_version")
    implementation("org.kodein.di:kodein-di:$kodein_version")
    implementation("org.kodein.di:kodein-di-framework-compose:$kodein_version")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutines_version")
    implementation("com.google.protobuf:protobuf-java-util:$protobuf_version")
    implementation("io.grpc:grpc-netty-shaded:$grpc_version")
    implementation("io.grpc:grpc-protobuf:$grpc_version")
    implementation("io.grpc:grpc-kotlin-stub:$grpc_kotlin_version")

    testImplementation(kotlin("test", kotlin_version))
}

java {
    sourceSets.main {
        java.srcDirs("build/generated/source/proto/main/grpc")
        java.srcDirs("build/generated/source/proto/main/java")
    }
}

kotlin {
    sourceSets.main {
        kotlin.srcDirs("build/generated/source/proto/main/grpckt")
    }
}

compose.desktop {
    application {
        mainClass = "MainKt"
        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "EnderVision"
            packageVersion = "1.0.0"
        }
    }
}

protobuf {
    protoc {
        artifact = "com.google.protobuf:protoc:$protobuf_version"
    }
    plugins {
        id("grpc") {
            artifact = "io.grpc:protoc-gen-grpc-java:$grpc_version${if (osdetector.os == "osx") ":osx-x86_64" else ""}"
        }
        id("grpckt") {
            artifact = "io.grpc:protoc-gen-grpc-kotlin:$grpc_kotlin_version:jdk7@jar"
        }
    }
    generateProtoTasks {
        all().forEach {
            it.plugins {
                id("grpc")
                id("grpckt")
            }
        }
    }
}