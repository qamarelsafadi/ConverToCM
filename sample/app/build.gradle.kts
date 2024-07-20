plugins {
    alias(libs.plugins.android.application)
    //todo 2  : remove plugins and replace them with this one
    kotlin("android")
    // todo 6 : add jetbrains compose plugin here
    id("org.jetbrains.compose")
    alias(libs.plugins.compose.compiler)

}

android {
    namespace = "com.qamar.convertocm"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.qamar.convertocm"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(libs.androidx.activity.compose)
    // todo 8 : use compose
    implementation(compose.material3)

    // todo 14 : add common module
    implementation(project(":common"))

}