plugins {
    kotlin("multiplatform")
}

group = "com.uramnoil"
version = "0.1"

repositories {
    mavenCentral()
}

kotlin {
    jvm {
        compilations.all {
            kotlinOptions.jvmTarget = "11"

            tasks.withType<Test> {
                this.testLogging {
                    this.showStandardStreams = true
                }
            }
        }
    }
    sourceSets {
        val commonMain by getting {}
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
                implementation(kotlin("test-junit"))
            }
        }
    }
}
