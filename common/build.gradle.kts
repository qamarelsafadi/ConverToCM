import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi

// todo 9 : add common directory
// todo 10 : add build.gradle.kts file

plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("org.jetbrains.compose")
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.kotlin.native.cocopods)
}

kotlin {
    cocoapods {
        version = "1.12.1"
        summary = "Compose application framework"
        homepage = "http://github.com/qamarelsafadi"
        ios.deploymentTarget = "14.1"
        podfile = project.file("../sample/ios/Podfile")
        framework {
            baseName = "ComposeApp"
            isStatic = true
        }
    }
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    jvm("desktop")
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "ComposeApp"
            isStatic = true
        }
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material)
                implementation(compose.material3)
            }
        }

        val androidMain by getting {
            dependencies {

            }
        }

        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
            dependencies {
            }
        }
    }
}


android {
    namespace = "com.qamar.convertocm"
    compileSdk = 34
    defaultConfig {
        minSdk = 24
    }
}
